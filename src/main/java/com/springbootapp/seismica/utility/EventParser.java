package com.springbootapp.seismica.utility;

import com.springbootapp.seismica.model.EventData;

import java.util.regex.Pattern;

public class EventParser {

    public EventParser() {
    }

    public EventData parseEventData(String data) {
        EventData eventData = new EventData();
        String[] eventDataArray = data.split("\n");

        for (int i = 0; i <eventDataArray.length; i++) {
            if (Pattern.compile("^#").matcher(eventDataArray[i]).find() == false &&
            Pattern.compile("^Sample").matcher(eventDataArray[i]).find() == false) {
                eventData.getWave().add(Float.parseFloat(eventDataArray[i]));
            } else {
                eventData.getMetadata().add(eventDataArray[i].substring(2));
            }
        }

        return eventData;
    }

}
