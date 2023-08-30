package com.springbootapp.seismica.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogObject {
    private List<Integer> ids;
    private List<String> times;
    private List<Float> latitudes;
    private List<Float> longitudes;
    private List<Float> depths;
    private List<String> authors;
    private List<String> catalogs;
    private List<String> contributors;
    private List<String> contributorsId;
    private List<String> magTypes;
    private List<Float> magnitudes;
    private List<String> magAuthors;
    private List<String> locations;

    public CatalogObject() {
        this.ids = new ArrayList<>();
        this.times = new ArrayList<>();
        this.latitudes = new ArrayList<>();
        this.longitudes = new ArrayList<>();
        this.depths = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.catalogs = new ArrayList<>();
        this.contributors = new ArrayList<>();
        this.contributorsId = new ArrayList<>();
        this.magTypes = new ArrayList<>();
        this.magnitudes = new ArrayList<>();
        this.magAuthors = new ArrayList<>();
        this.locations = new ArrayList<>();
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<Float> getLatitudes() {
        return latitudes;
    }

    public void setLatitudes(List<Float> latitudes) {
        this.latitudes = latitudes;
    }

    public List<Float> getLongitudes() {
        return longitudes;
    }

    public void setLongitudes(List<Float> longitudes) {
        this.longitudes = longitudes;
    }

    public List<Float> getDepths() {
        return depths;
    }

    public void setDepths(List<Float> depths) {
        this.depths = depths;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<String> catalogs) {
        this.catalogs = catalogs;
    }

    public List<String> getContributors() {
        return contributors;
    }

    public void setContributors(List<String> contributors) {
        this.contributors = contributors;
    }

    public List<String> getContributorsId() {
        return contributorsId;
    }

    public void setContributorsId(List<String> contributorsId) {
        this.contributorsId = contributorsId;
    }

    public List<String> getMagTypes() {
        return magTypes;
    }

    public void setMagTypes(List<String> magTypes) {
        this.magTypes = magTypes;
    }

    public List<Float> getMagnitudes() {
        return magnitudes;
    }

    public void setMagnitudes(List<Float> magnitudes) {
        this.magnitudes = magnitudes;
    }

    public List<String> getMagAuthors() {
        return magAuthors;
    }

    public void setMagAuthors(List<String> magAuthors) {
        this.magAuthors = magAuthors;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}
