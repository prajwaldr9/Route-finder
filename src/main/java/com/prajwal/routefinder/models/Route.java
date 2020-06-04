package com.prajwal.routefinder.models;

import javax.persistence.*;

@Entity
@Table(name="route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String startLocation; // todo: make it startLocation

    @Column
    private String fromLocation;

    @Column
    private String toLocation;

    @Column
    private String viaRoutes;

    @Column
    private String deptTime;

    public Route(){

    }

    public Route(int id) {
        this.id = id;
    }

    public Route(int id, String startLocation, String fromLocation, String toLocation, String viaRoutes, String deptTime) {
        this.id = id;
        this.startLocation = startLocation;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.viaRoutes = viaRoutes;
        this.deptTime = deptTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getViaRoutes() {
        return viaRoutes;
    }

    public void setViaRoutes(String viaRoutes) {
        this.viaRoutes = viaRoutes;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }
}
