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

            header.clickLogin();
            signInModal.signInUser();

            Assert.assertTrue(header.isUserSignedIn());
    }

    @Test
    public void LoginFailure_Firefox() throws InterruptedException {

        //data test
        User testUser = dataHelper.existingUser();
        testUser.password = "1234567";

        //steps
        header.clickLogin();
        signInModal.signInUser(testUser);

        //asserts
        Assert.assertEquals("We're sorry, something went wrong signing in. Please make sure your information is correct and try again.",
                signInModal.errorMessageContent());
    }

}
