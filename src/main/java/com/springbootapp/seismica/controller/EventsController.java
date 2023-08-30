package com.springbootapp.seismica.controller;

import com.springbootapp.seismica.model.CatalogObject;
import com.springbootapp.seismica.utility.EventsParser;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@RestController
public class EventsController {

    private String eventsHttp = "http://service.iris.edu/fdsnws/event/1/query";
    private EventsParser eventsParser = new EventsParser();

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/earthquakes/{sdate}/{edate}/{minM}/{maxM}")
    public CatalogObject getEvents(@PathVariable String sdate,
                                    @PathVariable String edate,
                                    @PathVariable String minM,
                                    @PathVariable String maxM){
        String url = String.format(eventsHttp+"?starttime=%s&endtime=%s&minmagnitude=%s&maxmagnitude=%s&format=geocsv", sdate, edate, minM, maxM);

        RestTemplate restTemplate = new RestTemplate();
        String events = restTemplate.execute(url, HttpMethod.GET, null, clientHttpResponse -> {
            InputStream response = clientHttpResponse.getBody();
            String data = new BufferedReader(
                    new InputStreamReader(response, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            return data;
        });

        CatalogObject eventsObject = eventsParser.parseEventsData(events);

        return eventsObject;
    }
}
