package com.api.testautomation.utils;

import com.api.testautomation.stepdefs.Hooks;
import org.openqa.selenium.WebDriver;
import com.api.testautomation.pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	//public TestBase testBase;
	//public GenericUtils genericUtils;
	//private WebDriver driver = Hooks.driver;
//BaseClass baseClass=new BaseClass(driver);

	
	public TestContextSetup() throws IOException
	{
		/*testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
		
		*/
		

	}
	
}
