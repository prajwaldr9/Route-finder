package com.prajwal.routefinder.dao;

import java.util.List;

import com.prajwal.routefinder.Beans.UniqueFromAndToLocation;
import com.prajwal.routefinder.models.Route;

public interface RouteDAO {

	public List<Route> findAll();

	public List<Route> findResultsByLocation(String fromLocation, String toLocation);

	public Route findById(int id);

	public void save(Route route);

	public void deleteById(int id);

    public void deleteAllTableContents(String tableName);

    public UniqueFromAndToLocation getUniqueFromAndToLocation();
}
