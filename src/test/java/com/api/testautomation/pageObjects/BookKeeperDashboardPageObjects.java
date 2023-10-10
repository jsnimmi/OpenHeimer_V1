package com.api.testautomation.pageObjects;

import com.api.testautomation.utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BookKeeperDashboardPageObjects extends BaseClass {
    public WebDriver driver;

    public BookKeeperDashboardPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//button[contains(text(),'Generate Tax Relief File')]")
    public WebElement btnGenerateTaxFile;

    public void clickOnGenerateTaxFile() throws Exception {
        Thread.sleep(1000);
        btnGenerateTaxFile.click();
        Thread.sleep(1000);
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }
        return flag;
    }

}