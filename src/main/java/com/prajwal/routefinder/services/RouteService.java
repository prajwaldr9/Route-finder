package com.prajwal.routefinder.services;

import com.prajwal.routefinder.Beans.UniqueFromAndToLocation;
import com.prajwal.routefinder.models.Route;

import java.io.IOException;
import java.util.List;

public interface RouteService {

	public List<Route> findAll();

	public List<Route> getResultsByLocation(String fromLoction, String toLocation);

	public Route findById(int theId);
	
	public void save(Route theRoute);
	
	public void deleteById(int theId);

	public void savePdfDataToDb() throws IOException;

    public void cleanUpDB(String tableName);

    public UniqueFromAndToLocation getUniqueFromAndToLocation();
}
