package Specs;

import Helpers.DriverHelper;
import Model.User;
import Pages.SignInModal;
import org.junit.Ignore;
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

    @Test
    public void Login_RememberMe_Receives_AutoLogin_Cookie() throws InterruptedException {

        //data test
        User testUser = dataHelper.existingUser();

        //steps
        header.clickLogin();
        signInModal.signInUser(testUser,true);
        Thread.sleep(6000);

        //asserts
        Assert.assertTrue(driverHelper.isLocalStorage("refreshToken"));
    }

    @Test
    public void Login_Not_RememberMe_Receives_AutoLogin_Cookie() throws InterruptedException {

        //data test
        User testUser = dataHelper.existingUser();

        //steps
        header.clickLogin();
        signInModal.signInUser(testUser,false);
        Thread.sleep(5000);

        //asserts
        Assert.assertFalse(driverHelper.isLocalStorage("autoLoginToken"));
    }

    @Test
    public void LogOutSuccessful_Should_Remove_AutoLogin_Cookie() throws InterruptedException {

        //data test
        User testUser = dataHelper.existingUser();

        header.clickLogin();

        signInModal.signInUser(testUser,true);
        Thread.sleep(5000);

        header.signOut();

        Assert.assertFalse(driverHelper.isLocalStorage("autoLoginToken"));

    }


}
