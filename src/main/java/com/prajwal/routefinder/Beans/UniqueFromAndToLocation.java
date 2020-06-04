package com.prajwal.routefinder.Beans;

import java.util.List;

public class UniqueFromAndToLocation {
    List<String> uniqueFromLocationList;
    List<String> uniqueToLocationList;

    public UniqueFromAndToLocation() {
    }

    public List<String> getUniqueFromLocationList() {
        return uniqueFromLocationList;
    }

    public void setUniqueFromLocationList(List<String> uniqueFromLocationList) {
        this.uniqueFromLocationList = uniqueFromLocationList;
    }

    public List<String> getUniqueToLocationList() {
        return uniqueToLocationList;
    }

    public void setUniqueToLocationList(List<String> uniqueToLocationList) {
        this.uniqueToLocationList = uniqueToLocationList;
    }
}
