package org.amplienceTest.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    public ConfigFileReader(String propertyFilePath) {
        propertyFilePath = "src/test/resources/configuration/" + propertyFilePath;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(".properties not found at " + propertyFilePath);
        }
    }

    public String getApiEnvironment() {
        String url = properties.getProperty("BASE_URI");
        if (url != null) return url;
        else throw new RuntimeException("base_uri is not specified in the .properties file.");
    }

//    public String getUserId() {
//        String user_id = properties.getProperty("USER_ID");
//        if (user_id != null) return user_id;
//        else throw new RuntimeException("base_uri is not specified in the .properties file.");
//    }

}
