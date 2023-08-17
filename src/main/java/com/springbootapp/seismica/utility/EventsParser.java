package com.springbootapp.seismica.utility;

import com.springbootapp.seismica.model.CatalogObject;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class EventsParser {

    public EventsParser() {
    }

    public CatalogObject parseEventsData(String data) {

        CatalogObject eventsDataObject = new CatalogObject();
        String[] eventsStrings = data.split("\n");

        ArrayList<String[]> eventsArray = new ArrayList<>();

        for (int i = 0; i < eventsStrings.length; i++) {
            if (Pattern.compile("^#").matcher(eventsStrings[i]).find() == false && eventsStrings[i] != ""
                    && Pattern.compile("^EventID").matcher(eventsStrings[i]).find() == false) {
                String[] eventArray = eventsStrings[i].split("\\|");
                eventsArray.add(eventArray);
            }
        }

        for (String[] earthquake: eventsArray) {
            try {
                eventsDataObject.getIds().add(Integer.parseInt(earthquake[0]));
                eventsDataObject.getTimes().add(earthquake[1]);
                eventsDataObject.getLatitudes().add(Float.parseFloat(earthquake[2]));
                eventsDataObject.getLongitudes().add(Float.parseFloat(earthquake[3]));
                eventsDataObject.getDepths().add(Float.parseFloat(earthquake[4]));
                eventsDataObject.getAuthors().add(earthquake[5]);
                eventsDataObject.getCatalogs().add(earthquake[6]);
                eventsDataObject.getContributors().add(earthquake[7]);
                eventsDataObject.getContributorsId().add(earthquake[8]);
                eventsDataObject.getMagTypes().add(earthquake[9]);
                eventsDataObject.getMagnitudes().add(Float.parseFloat(earthquake[10]));
                eventsDataObject.getMagAuthors().add(earthquake[11]);
                eventsDataObject.getLocations().add(earthquake[12]);
            } catch (Exception e) {
                throw new RuntimeException("Error: " + e.getMessage() + " for earthquake: " + earthquake[0] + earthquake[1] + earthquake[2] + earthquake[3] );
            }
        }

    return eventsDataObject;
    }


}
