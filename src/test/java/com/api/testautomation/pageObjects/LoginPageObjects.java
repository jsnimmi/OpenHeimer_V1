package com.api.testautomation.pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.api.testautomation.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects extends BaseClass {

    public WebDriver driver;

    public LoginPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement txtUserName;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement txtPassword;
    @FindBy(xpath = "(//input[@name='signInSubmitButton'])[2]")
    public WebElement btnSignIn;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement btnSubmit;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[1]")
    public WebElement slctAddUser;
    @FindBy(xpath = "(//*[@class='dropdown-item'])[2]")
    public WebElement slctUploadCSV;



    public void enterUsnPwdOnWorkingSystem(String userName, String password) throws Exception {
        Thread.sleep(1000);
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }

    /*public void selectUploadCSV() throws Exception {
        slctUploadCSV.click();
        Thread.sleep(2000);
    }*/

    public void selectAdd() throws Exception {
        slctAddUser.click();
        Thread.sleep(2000);
    }







    public void SelectFileFromWindows(String strArg1) throws IOException {
        // TODO Auto-generated method stub
        if (strArg1.equalsIgnoreCase("valid"))
            Runtime.getRuntime().exec(System.getProperty("user.dir") + "//src//test//resources//fileupload.exe");
            //Runtime.getRuntime().exec( "//src//test//resources//fileupload.exe");
        else
            Runtime.getRuntime().exec(System.getProperty("user.dir") + "//src//test//resources//fileuploadinvalid.exe");
    }



}
