package com.prajwal.routefinder.utils;

import java.io.File;

public class Helper {
    public static void cleanUpDir(String dirName) {
        File dir = new File(dirName);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println("Not deleting " + f.getName());
                } else {
                    f.delete();
                }
            }
        }
        System.out.println("Cleaning up " + dirName + " successful");
    }
}
