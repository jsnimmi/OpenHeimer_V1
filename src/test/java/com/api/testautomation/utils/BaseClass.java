package com.api.testautomation.utils;

import com.api.testautomation.pageObjects.LoginPageObjects;
import com.api.testautomation.utils.BaseClass;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseClass {
    private static WebDriver driver;


    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
    }

    public String getURL() throws IOException
    {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");
        return url;

    }


}