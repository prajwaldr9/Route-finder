package com.prajwal.routefinder.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.prajwal.routefinder.Beans.UniqueFromAndToLocation;
import com.prajwal.routefinder.dao.RouteDAO;
import com.prajwal.routefinder.models.Route;
import com.prajwal.routefinder.utils.Mapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RouteServiceImpl implements RouteService {

    private RouteDAO routeDAO;

    @Autowired
    public RouteServiceImpl(RouteDAO theRouteDAO) {
        routeDAO = theRouteDAO;
    }

    @Override
    @Transactional
    public List<Route> findAll() {
        return routeDAO.findAll();
    }

    @Override
    @Transactional
    public List<Route> getResultsByLocation(String fromLocation, String toLocation) {
        System.out.println("getResultByLocation");
        fromLocation = Mapper.locationMapper.getOrDefault(fromLocation, fromLocation);
        toLocation = Mapper.locationMapper.getOrDefault(toLocation, toLocation);
        return routeDAO.findResultsByLocation(fromLocation, toLocation);
    }


    @Override
    @Transactional
    public Route findById(int theId) {
        return routeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Route theRoute) {
        routeDAO.save(theRoute);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        routeDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public void cleanUpDB(String tableName) {
        routeDAO.deleteAllTableContents(tableName);
        System.out.println(tableName + " cleaned up");
    }

    @Override
    public UniqueFromAndToLocation getUniqueFromAndToLocation() {
        UniqueFromAndToLocation uniqueFromAndToLocation = routeDAO.getUniqueFromAndToLocation();
//        uniqueFromAndToLocation.getUniqueFromLocationList().forEach(ele -> (ele.substring(0, 1).toUpperCase() + ele.substring(1)));
        return uniqueFromAndToLocation;
    }

    /**
     * This method sees already downloaded files from pdfRepo directory
     * parses the pdf and sends line of each pdf to patternMatcher method
     * Storing will be done by patternMatcher method
     *
     * @throws IOException
     */
    @Override
    @Transactional
    public void savePdfDataToDb() throws IOException {
        String pdfRepo = System.getProperty("user.home") + "/storage/route_finder/PDFrepo"; // todo declare this as a constant somewhere
        File folder = new File(pdfRepo);
        File[] listOfFiles = folder.listFiles();
        final long startTime = System.currentTimeMillis();
        System.out.println("test1");
        if (listOfFiles != null) {
            int counter = 0;
            int totalFiles = listOfFiles.length;
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String fromLocation = fileName.substring(0, fileName.length() - 4);
                    fromLocation = Mapper.pathMapper.get(fromLocation);
                    PDDocument document = PDDocument.load(file);
                    PDFTextStripper pdfStripper = new PDFTextStripper();
                    String pdfData = pdfStripper.getText(document);
                    String[] arrOfStr = pdfData.split("\n");
                    for (String line : arrOfStr) {
                        document.close();
                        patternMatcher(line, fromLocation);
                    }
                    System.out.println(++counter + "/" + totalFiles + " Added entries of " + fromLocation + " to DB");
                }
            }
        } else {
            System.out.println("No files found in repo " + pdfRepo);
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (double) (endTime - startTime) / 1000 + "sec\n\n");

        System.out.println("Successful in adding data to db");
    }

    /**
     * This method gets the line
     * as string and parses from, to, start location and departure time
     * Also it saves it in the database
     *
     * @param line : line such as 397 BENGALURU SHIVAMOGGA EXPRESS KADUR, TARIKERE,BHADRAVATI 17.30
     */
    private void patternMatcher(String line, String fromLocation) {

        ArrayList<String> patternList = new ArrayList<>();

        String pattern1 = ".*? (.*) (K R Nagara) (.*) (?:ORDINARY|Ordinary) (.*)"; // exp : K R Nagara
        String pattern2 = ".* (.*) (.*) (?:EXPRESS|Express) (.*) (.*)"; // Express in the middle
        String pattern3 = ".*? (.*?) (.*?) (.*) (?:EXPRESS|Express) (.*)"; // Express in last but one
        String pattern4 = ".*? (.*?) (.*?) (.*) (?:ORDINARY|Ordinary) (.*)"; // Ordinary in last but one
        String pattern5 = ".*? (.*?) (.*?) (.*) (?:Non-Stop) (.*)"; // Ordinary in last but one

        patternList.add(pattern1);
        patternList.add(pattern2);
        patternList.add(pattern3);
        patternList.add(pattern4);
        patternList.add(pattern5);

        boolean patternMatched = false;
        for (String pattern : patternList) {
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            if (m.find()) {
                patternMatched = true;
                String startLocation = m.group(1);
                String toLocation = m.group(2);
                String viaRoutes = m.group(3);
                String deptTime = m.group(4);
                if (startLocation == null || toLocation == null || viaRoutes == null || deptTime == null) {
                    System.out.println("NO MATCH" + fromLocation + "and string is");
                }
                Route route = new Route(0, startLocation, fromLocation, toLocation, viaRoutes, deptTime);
                save(route);
                break;
            }
        }

    }
}






