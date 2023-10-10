package com.api.testautomation.stepdefs;

import com.api.testautomation.pageObjects.BookKeeperDashboardPageObjects;
import com.api.testautomation.pageObjects.LoginPageObjects;
import com.api.testautomation.pageObjects.UploadCSVfilePageObjects;
import com.api.testautomation.testStoreConfigFiles.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class uploadCSVfileStepdef {
    private WebDriver driver = Hooks.driver;
    LoginPageObjects loginPagePageObjects = new LoginPageObjects(driver);

    ConfigFileReader configFileReader = new ConfigFileReader();

    BookKeeperDashboardPageObjects bookKeeperDashboardPageObjects = new BookKeeperDashboardPageObjects(driver);
    UploadCSVfilePageObjects uploadCSVfilePageObjects = new UploadCSVfilePageObjects(driver);

    @Given("Launch the browser and navigate to OpenHeimer Working class Hero system")
    public void navigateToUrl() {
        if (configFileReader.getChromeBrowser().equalsIgnoreCase("chrome")) {
            String appUrl = configFileReader.getAppUrl();
            driver.get(appUrl);
            driver.manage().window().maximize();
        } else {
            System.setProperty("webdriver.edge.driver", configFileReader.getEdgeDriverPath());
            driver = new EdgeDriver();
            String appUrl = configFileReader.getAppUrl();
            driver.get(appUrl);
            driver.manage().window().maximize();
        }
    }

    @And("user enters username {string}, password {string} and login to working system")
    public void user_enters_username_password_and_login_to_working_system(String userName, String password) throws Exception {
        Thread.sleep(5000);
        loginPagePageObjects = new LoginPageObjects(driver);
        // loginPagePageObjects.enterUsernamePasswordAndLogin(userName, password);
        loginPagePageObjects.enterUsnPwdOnWorkingSystem(userName,password);
    }

    @And("select Add Hero on the Clerk dashboard")
    public void select_Add_Hero_on_the_Clerk_dashboard() throws Exception {
        uploadCSVfilePageObjects = new UploadCSVfilePageObjects(driver);
        uploadCSVfilePageObjects.clickOnAddHero();
        uploadCSVfilePageObjects.selectUploadCSV();
    }

    @When("User select the Choose File area to upload the {string} file")
    public void user_select_the_Choose_File_area_to_upload_the_file(String strArg1) throws Throwable {
        Thread.sleep(3000);
        uploadCSVfilePageObjects.SelectBrowseButton();
        Thread.sleep(3000);
        //loginPagePageObjects.SelectFileFromWindows(strArg1);// need to check again
        Thread.sleep(3000);
        uploadCSVfilePageObjects.setFileDragAndDrop("C:\\Test\\data1.csv");
        Thread.sleep(3000);
        System.out.println("File uploaded successfully");
    }

    @And("select Generate Tax Relief file on the bk dashboard")
    public void select_Generate_Tax_Relief_file_on_the_bk_dashboard() throws Exception {
        bookKeeperDashboardPageObjects.clickOnGenerateTaxFile();
        Thread.sleep(2000);
    }

    @And("validate the downloaded Tax Relief file {string} {string}")
    public void validate_the_downloaded_Tax_Relief_file(String downloadPath, String fileName) throws Exception {
        bookKeeperDashboardPageObjects.isFileDownloaded(downloadPath, fileName);
        Thread.sleep(2000);
    }

    @And("validate the response")
    public void validate_the_response() throws Exception {
        uploadCSVfilePageObjects.uploadCSVFailedmsg();
        Thread.sleep(2000);
    }
}