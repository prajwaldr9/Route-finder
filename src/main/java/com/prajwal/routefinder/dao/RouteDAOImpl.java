package com.prajwal.routefinder.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.prajwal.routefinder.Beans.UniqueFromAndToLocation;
import com.prajwal.routefinder.models.Route;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.prajwal.routefinder.utils.Mapper;


@Repository
public class RouteDAOImpl implements RouteDAO {

    private EntityManager entityManager;

    @Autowired
    public RouteDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Route> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Route> theQuery =
                currentSession.createQuery("from Route", Route.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Route> findResultsByLocation(String fromLocation, String toLocation) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Route> theQuery =
                currentSession.createQuery("from Route where lower(fromLocation) = lower(:fromLocation)" +
                        " and lower(toLocation) = lower(:toLocation)", Route.class)
                        .setParameter("fromLocation", fromLocation)
                        .setParameter("toLocation", toLocation);
        return theQuery.getResultList();
    }


    @Override
    public Route findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Route.class, theId);
    }


    @Override
    public void save(Route theRoute) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theRoute);
    }


    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery =
                currentSession.createQuery(
                        "delete from Route where id=:routeId");
        theQuery.setParameter("routeId", theId);
        theQuery.executeUpdate();
    }

    @Override
    public void deleteAllTableContents(String tableName) {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryString = "delete from " + tableName;
        Query theQuery =
                currentSession.createQuery(queryString);
        theQuery.executeUpdate();
    }

    @Override
    public UniqueFromAndToLocation getUniqueFromAndToLocation() {
        Session currentSession = entityManager.unwrap(Session.class);
        Criteria criteria = currentSession.createCriteria(Route.class);
        criteria.setProjection(Projections.distinct(Projections.property("fromLocation")));
        List fromLocationList = criteria.list();
        criteria.setProjection(Projections.distinct(Projections.property("toLocation")));
        List toLocationList = criteria.list();
        for (Map.Entry<String,String> entry : Mapper.locationMapper.entrySet())
            toLocationList.add(entry.getKey());
            toLocationList.add(entry.getKey());

        UniqueFromAndToLocation uniqueFromAndToLocation = new UniqueFromAndToLocation();
        uniqueFromAndToLocation.setUniqueFromLocationList(fromLocationList);
        uniqueFromAndToLocation.setUniqueToLocationList(toLocationList);
        return uniqueFromAndToLocation;
    }
}







