package Specs;

import Helpers.DataHelper;
import Helpers.DriverHelper;
import Pages.LoginPage;
import Pages.PageObjectSample;
import org.openqa.selenium.WebDriver;

public class SuperBaseClass {
    //driver
    WebDriver driver;

    //pages

    PageObjectSample pageObjectSample;
    LoginPage loginPage;
    WelcomePage welcomePage;
    CreateUser createUser;

    //helpers
    DataHelper dataHelper;
    DriverHelper driverHelper;


    protected void InitPages(){


        pageObjectSample = new PageObjectSample(this.driver);
        LoginPage loginPage = new LoginPage();
        WelcomePage welcomePage = new WelcomePage();
        CreateUser createUser  = new CreateUser();

    }

    protected void InitHelpers(String baseUrl){
        dataHelper = new DataHelper();
        driverHelper = new DriverHelper(driver, baseUrl);
    }
}
