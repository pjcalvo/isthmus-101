package Specs;

import Model.User;
import Pages.SignInModal;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends SpecsBaseClass{

    @Test
    public void LoginSuccessful() {

            header.get().clickLogin();
            signInModal.get().signInUser();

            Assert.assertTrue(header.get().isUserSignedIn());
    }

    @Test
    public void LoginFailure() throws InterruptedException {

        //data test
        User testUser = dataHelper.nonexistingUser();

        //steps
        header.get().clickLogin();
        signInModal.get().signInUser(testUser);

        //asserts
        Assert.assertEquals("We're sorry, something went wrong signing in. Please make sure your information is correct and try again.",
                signInModal.get().errorMessageContent());
    }

}
