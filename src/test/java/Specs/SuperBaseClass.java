package Specs;

import Helpers.DataHelper;
import Helpers.DriverHelper;
import Pages.Header;
import Pages.ProductPage;
import Pages.SignInModal;
import org.openqa.selenium.WebDriver;

public class SuperBaseClass {
    //driver

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //pages
    protected ThreadLocal<SignInModal> signInModal = new ThreadLocal<>();
    protected ThreadLocal<Header> header = new ThreadLocal<>();
    protected ThreadLocal<ProductPage> productPage = new ThreadLocal<>();

    //helpers
    DataHelper dataHelper;
    protected ThreadLocal<DriverHelper> driverHelper = new ThreadLocal<>();


    protected void InitPages(){
        signInModal.set(new SignInModal(this.driver.get(), dataHelper));
        header.set(new Header(this.driver.get()));
        productPage.set(new ProductPage(this.driver.get(), driverHelper.get()));
    }

    protected void InitHelpers(String baseUrl){
        dataHelper = new DataHelper();
        driverHelper.set(new DriverHelper(this.driver.get(), baseUrl));
    }
}
