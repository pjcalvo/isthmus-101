package Specs;

import Helpers.DataHelper;
import Helpers.DriverHelper;
import Helpers.ExcelHelper;
import Pages.Header;
import Pages.ProductPage;
import Pages.SignInModal;
import org.openqa.selenium.WebDriver;

public class SuperBaseClass {
    //driver
    WebDriver driver;

    //pages
    SignInModal signInModal;
    Header header;
    ProductPage productPage;

    //helpers
    DataHelper dataHelper;
    DriverHelper driverHelper;


    protected void InitPages(){
        signInModal = new SignInModal(this.driver, dataHelper);
        header = new Header(this.driver);
        productPage = new ProductPage(this.driver, driverHelper);
    }

    protected void InitHelpers(String baseUrl){
        dataHelper = new DataHelper(new ExcelHelper());
        driverHelper = new DriverHelper(driver, baseUrl);
    }
}
