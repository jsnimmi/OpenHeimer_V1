package com.api.testautomation.testStoreConfigFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/*
 * This class defines read basic browser, drivers and other configuration details
 */


public class ConfigFileReader {

    public Properties properties;
    String driverPath = "";
    private String propertyFilePath = "configs\\configuration.properties";

    public ConfigFileReader() {
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
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getChromeDriverPath() {
        String chromeDriverPath = properties.getProperty("chromeDriverPath");
        if (driverPath != null)
            return chromeDriverPath;
        else
            throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getEdgeDriverPath() {
        String edgeDriverPath = properties.getProperty("edgeDriverPath");
        if (driverPath != null)
            return edgeDriverPath;
        else
            throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getChromeBrowser() {
        String browserType = properties.getProperty("chromeBrowserName");
        return browserType;
    }

    public String getEdgeBrowser() {
        String browserType = properties.getProperty("edgeBrowserName");
        return browserType;
    }

    public String getAppUrl() {
        String appUrl = properties.getProperty("appUrl");
        return appUrl;
    }

    public String getUserName() {
        String userName = properties.getProperty("userName");
        return userName;
    }

    public String getUserPassword() {
        String userPassword = properties.getProperty("userPassword");
        return userPassword;
    }

    public String getUserConfirmPassword() {
        String userConfirmPassword = properties.getProperty("confirmPassword");
        return userConfirmPassword;
    }

    public String getReportConfigPath() {

        String extentReportConfigPath = properties.getProperty("reportConfigPath");
        return extentReportConfigPath;
    }

}
