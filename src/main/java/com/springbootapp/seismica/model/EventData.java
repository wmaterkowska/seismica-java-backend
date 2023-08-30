package com.springbootapp.seismica.model;

import java.util.ArrayList;
import java.util.List;

public class EventData {
    private List<String> metadata;
    private List<Float> wave;

    public EventData() {
        this.metadata = new ArrayList<>();
        this.wave = new ArrayList<>();
    }

    public List<String> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<String> metadata) {
        this.metadata = metadata;
    }

    public List<Float> getWave() {
        return wave;
    }

    public void setWave(List<Float> wave) {
        this.wave = wave;
    }
}
