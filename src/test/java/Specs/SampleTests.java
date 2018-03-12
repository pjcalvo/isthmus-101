package Specs;

import Helpers.DataHelper;
import Helpers.DriverHelper;
import Model.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleTests extends SpecsBaseClass{

    @Test (dataProvider = "AuthenticationUsers1", dataProviderClass = DataHelper.class)
    public void LoginSuccessful(String sEmail, String sPassword) {

            User testUser = new User(sEmail, sPassword);

              pageObjectSample.clickLogin();
          //  signInModal.signInUser(testUser);

           // Assert.assertTrue(header.isUserSignedIn());
    }

}
