package com.api.testautomation.pageObjects;

import com.api.testautomation.stepdefs.Hooks;
import com.api.testautomation.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class UploadCSVfilePageObjects extends BaseClass {



    //public WebDriver driver;
    private WebDriver driver = Hooks.driver;

    public UploadCSVfilePageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//button[@class='btn btn-secondary dropdown-toggle']")
    public WebElement drpAddHero;
    @FindBy(xpath = "//*[contains(text(),'Unable to process csv file!')]")
    public WebElement msgCSVfileUploadFile;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[2]")
    public WebElement slctUploadCSV;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement btnChooseFile;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement btnBack;

    By BrowseButton = By.xpath("//input[@type='file']");

    public void clickOnAddHero() throws Exception {
        Thread.sleep(18000);
        drpAddHero.click();
        Thread.sleep(2000);
    }

    public void selectUploadCSV() throws Exception {
        slctUploadCSV.click();
        Thread.sleep(2000);
    }

    public void setFileDragAndDrop(String givenFileName) throws Exception{
        btnChooseFile.sendKeys(givenFileName);
        SelectBrowseButton();
    }
    public void SelectBrowseButton() throws Exception
    {
        //Actions builder = new Actions(driver);
       // builder.moveToElement(driver.findElement(BrowseButton)).click().build().perform();
        //btnChooseFile.click();
        Thread.sleep(1500);
        btnBack.click();
        Thread.sleep(1500);
    }

    public void uploadCSVFailedmsg(){
        String actualString = driver.findElement(By.xpath("//*[contains(text(),'Unable to process csv file!')]")).getText();
        //assertTrue(actualString.contains("specific text"));
        //Assert.assertEquals(actualString.contains("Unable to process csv file! Please contact tech support for help!"));
        //String actualString = driver.findElement(By.xpath("xpath")).getText();

        String expectedString = "Unable to process csv file! Please contact tech support for help!";
        assertTrue(actualString.contains(expectedString));
    }

}
