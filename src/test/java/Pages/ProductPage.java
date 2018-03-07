package Pages;

import Helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    DriverHelper driverHelper;
    WebDriver driver;

    @FindBy (xpath = "//input[@data-selenium-id='btnContinue']")
    WebElement btnContinue;

    public ProductPage (WebDriver driver, DriverHelper driverHelper){
        this.driverHelper = driverHelper;
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    public void GoTo(String testProduct){
        driver.navigate().to(driverHelper.baseUrl + "lens/" + testProduct);
    }

    public void clickContinue(){
        btnContinue.click();
    }

    public void uploadFile(){
        driverHelper.uploadFile("RxImageUploadImage","\\Resources\\generate.png");
    }
}
