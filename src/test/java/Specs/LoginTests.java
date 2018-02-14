package Specs;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends SpecsBaseClass{

    @BeforeMethod
    public void GoToTestPage() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.1800contactstest.com");
    }

    @Test ( priority = 1 )
    public void LoginSuccessful() {

            header.clickLogin();
            signInModal.signInUser("pablo@pablillo.com","123456");

            WebElement welcome = driver.findElement(By.xpath("//span[@data-selenium-id='lblIsSignedIn']"));
            Assert.assertTrue(welcome.isDisplayed());
    }

    @Test ( priority = 2 )
    public void LoginFailure() throws InterruptedException {

        header.clickLogin();
        signInModal.signInUser("pablo@pablillo.com","1234567");

    }

}
