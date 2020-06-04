package com.prajwal.routefinder.services;

import com.prajwal.routefinder.utils.Helper;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CronService {

    private RouteService routeService;
    private static String pdfRepoDir = System.getProperty("user.home") + "/storage/route_finder/PDFrepo";

    @Autowired
    public CronService(RouteService theRouteService) {
        routeService = theRouteService;
    }

    @Scheduled(fixedDelay = 10000000)
    public void downloadPdfData() throws IOException {
        if ("True".equals(System.getenv("DOWNLOAD_FILES"))){
            routeService.cleanUpDB("Route");
            Helper.cleanUpDir(pdfRepoDir);
            ArrayList<String> downloadLinks = crawlWebsite();
            downloadFiles(downloadLinks);
            routeService.savePdfDataToDb();
            System.out.println("Cron complete");
        }
        else{
            System.out.println("Download files set to False");
        }
    }


    /**
     * This method crawls the ksrtc webiste timetable page and gets all links of pdfs
     *
     * @return list of pdf links
     * @throws IOException
     */
    private static ArrayList<String> crawlWebsite() throws IOException {
        System.out.println("Starting downloading PDF data");
        ArrayList<String> downloadLinks = new ArrayList<>();
        String html = Jsoup.connect("https://ksrtc.in/pages/timetable.html").get().html();
        String pattern = "(?s)<ol id=\"ttbl\">(.*)\n.*</ol>";
        Pattern r = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher m = r.matcher(html);
        if (m.find()) {
            String processedString = m.group(1);
            String links[] = processedString.split("\n");
            for (String link : links) {
                if (!link.contains("https"))
                    continue;
                pattern = "a href=\"(.*)\">";
                r = Pattern.compile(pattern, Pattern.DOTALL);
                m = r.matcher(link);
                if (m.find())
                    downloadLinks.add((m.group(1)));
                else
                    System.out.println("No match found for string " + link);
            }
        } else {
            System.out.println("NO MATCH in parsing website");
        }
        System.out.println("Total links found: " + downloadLinks.size());
        return downloadLinks;
    }

    /**
     * This method downloads the pdf files and store in resources/PDFrepo dir
     *
     * @param downloadLinks
     */
    private static void downloadFiles(ArrayList<String> downloadLinks) {
        String localFilename;
        for (String url : downloadLinks) {
            localFilename = pdfRepoDir + "/" + url.substring(url.lastIndexOf("timeTable/") + 10); // todo change to PDFrepo
            // todo add a method to delete the files from db
            try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream()); FileOutputStream fileOutputStream =
                    new FileOutputStream(localFilename)) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
                System.out.println("Saved " + localFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Downloading files complete");
    }

}
