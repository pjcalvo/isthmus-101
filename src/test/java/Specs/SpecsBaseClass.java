package Specs;

import Pages.Header;
import Pages.SignInModal;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SpecsBaseClass {
    WebDriver driver;
    SignInModal signInModal;
    Header header;

    @BeforeMethod
    public void InitializeTests(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        InitPages();

        driver.get("https://www.1800contactstest.com");
    }

    @AfterMethod
    public  void CleanUpDriver(){
        driver.quit();
    }

    private void InitPages(){
        signInModal = new SignInModal(this.driver);
        header = new Header(this.driver);
    }
}
