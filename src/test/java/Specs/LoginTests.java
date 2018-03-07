package Specs;

import Helpers.DataHelper;
import Helpers.DriverHelper;
import Model.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends SpecsBaseClass{

    @Test (dataProvider = "AuthenticationUsers", dataProviderClass = DataHelper.class)
    public void LoginSuccessful(String sEmail, String sPassword) {

            User testUser = new User(sEmail, sPassword);

            header.clickLogin();
            signInModal.signInUser(testUser);

            Assert.assertTrue(header.isUserSignedIn());
    }

    @Test (enabled = false)
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

    @Test (enabled = false)
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

    @Test (enabled = false)
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

    @Test (enabled = false)
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
