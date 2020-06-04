package com.prajwal.routefinder.controller;

import java.io.IOException;
import java.util.List;

import com.prajwal.routefinder.Beans.UniqueFromAndToLocation;
import com.prajwal.routefinder.models.Route;
import com.prajwal.routefinder.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@CrossOrigin(origins = "*", maxAge = 3600) //todo: restrict only to the required domains
@RestController
@RequestMapping("/api")
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService theRouteService) {
        routeService = theRouteService;
    }

    @PostConstruct
    public void pushDataToDB() throws IOException {
//        routeService.savePdfDataToDb();
        System.out.println("not doing anything");
    }

    @GetMapping("/routes")
    public List<Route> findAll() {
        return routeService.findAll();
    }

    @GetMapping("/routes/getUniqueFromAndToLocation")
    public UniqueFromAndToLocation getUniqueFromAndToLocation() {
        return routeService.getUniqueFromAndToLocation();
    }

    @GetMapping("/ping")
    public String ping() {
        return "Route finder is running";
    }

    @GetMapping(value = "/routes", params = {"fromLocation", "toLocation"})
    public List<Route> findByLocation(@RequestParam("fromLocation") String fromLocation, @RequestParam("toLocation") String toLocation) {
        List<Route> routes = routeService.getResultsByLocation(fromLocation, toLocation);
        return routes;
    }

    @GetMapping("/routes/{routeId}")
    public Route getRoute(@PathVariable int routeId) {
        Route theRoute = routeService.findById(routeId);
        if (theRoute == null) {
            throw new RuntimeException("Route id not found - " + routeId);
        }
        return theRoute;
    }

    @PostMapping("/routes")
    public Route addRoute(@RequestBody Route theRoute) {
        theRoute.setId(0);
        routeService.save(theRoute);
        return theRoute;
    }

    @PutMapping("/routes")
    public Route updateRoute(@RequestBody Route theRoute) {
        routeService.save(theRoute);
        return theRoute;
    }

    @DeleteMapping("/routes/{routeId}")
    public String deleteRoute(@PathVariable int routeId) {
        Route tempRoute = routeService.findById(routeId);
        if (tempRoute == null) {
            throw new RuntimeException("Route id not found - " + routeId);
        }
        routeService.deleteById(routeId);
        return "Deleted route id - " + routeId;
    }

}










