package com.springbootapp.seismica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EventDataController {




    @GetMapping(value = "/eventData/:date")
    private String getEvents(){
        String url = "http://";
        RestTemplate restTemplate = new RestTemplate();

        Object[] events = restTemplate.getForObject(url, Object[].class);

        return "200";
    }
}
