package com.example;

import java.io.File;

public class CreateFolder {

    public String createFolders(String[] folders) {
        String path = "F:\\"; 
        StringBuilder result = new StringBuilder(); // To store the results of folder creation

        for (String folder : folders) {
            folder = folder.trim(); 
            String folderPath = path + folder;
            File file = new File(folderPath);
            if (!file.exists()) {
                if (file.mkdir()) {
                    result.append("Directory ").append(folder).append(" is created!\n");
                } else {
                    result.append("Failed to create directory ").append(folder).append("!\n");
                }
            } else {
                result.append("Directory ").append(folder).append(" already exists.\n");
            }
        }
        
        return result.toString(); // Return all results as a single string
    }
}

