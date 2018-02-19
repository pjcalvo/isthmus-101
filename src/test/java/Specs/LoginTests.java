package Specs;

import Pages.SignInModal;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends SpecsBaseClass{

    @Test ( priority = 1 )
    public void LoginSuccessful() {

            header.clickLogin();
            signInModal.signInUser("pablo@pablillo.com","123456");

            Assert.assertTrue(header.isUserSignedIn());
    }

    @Test ( priority = 2 )
    public void LoginFailure() throws InterruptedException {

        header.clickLogin();
        signInModal.signInUser("pablo@pablillo.com","1234567");

        Assert.assertEquals("We're sorry, something went wrong signing in.  Please make sure your information is correct and try again.",
                signInModal.errorMessageContent());
    }

}
