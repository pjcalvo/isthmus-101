package Specs;

import Helpers.DataHelper;
import Helpers.DriverHelper;
import Pages.PageObjectSample;
import org.openqa.selenium.WebDriver;

public class SuperBaseClass {
    //driver
    WebDriver driver;

    //pages
    PageObjectSample pageObjectSample;

    //helpers
    DataHelper dataHelper;
    DriverHelper driverHelper;


    protected void InitPages(){
        pageObjectSample = new PageObjectSample(this.driver);
    }

    protected void InitHelpers(String baseUrl){
        dataHelper = new DataHelper();
        driverHelper = new DriverHelper(driver, baseUrl);
    }
}
