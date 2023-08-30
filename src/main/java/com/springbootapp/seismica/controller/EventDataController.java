package com.springbootapp.seismica.controller;

import com.springbootapp.seismica.model.EventData;
import com.springbootapp.seismica.utility.EventParser;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class EventDataController {

    private String NET = "IU";
    private String STA = "ANMO";
    private String CHANNEL = "BHZ";

    private String eventHttp = "http://service.iris.edu/fdsnws/dataselect/1/query?";
    private EventParser eventParser = new EventParser();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/eventData/{date}")
    private EventData getEvents(@PathVariable String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); // 2021-07-29T06:15:49Z
        Date originalDate = dateFormat.parse(date);
        long minusMiliseconds = 50000;
        long plusMiliseconds = 3000000;

        Date sdateObject = new Date(originalDate.getTime() - minusMiliseconds);
        Date edateObject = new Date(originalDate.getTime() + plusMiliseconds);

        String sdate = dateFormat.format(sdateObject);
        String edate = dateFormat.format(edateObject);

        String url = String.format(eventHttp+"net=%s&sta=%s&loc=00&cha=%s&start=%s&end=%s&format=geocsv.slist.inline", NET, STA, CHANNEL, sdate, edate);

        RestTemplate restTemplate = new RestTemplate();
        String eventData = restTemplate.execute(url, HttpMethod.GET, null, clientHttpResponse -> {
            InputStream response = clientHttpResponse.getBody();
            String data = new BufferedReader(
                    new InputStreamReader(response, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            return data;
        });

        EventData eventObject = eventParser.parseEventData(eventData);
        return eventObject;
    }
}
