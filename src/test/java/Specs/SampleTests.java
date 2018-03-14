package Specs;

import Helpers.DataHelper;
import Helpers.DriverHelper;
import Model.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleTests extends SpecsBaseClass{

    @Test (dataProvider = "AuthenticationUsers1", dataProviderClass = DataHelper.class)
    public void LoginSuccessful(String sUserName, String sPassword) {

            User testUser = new User(sUserName, sPassword);

              pageObjectSample.signInUser();
          //  signInModal.signInUser(testUser);

           // Assert.assertTrue(header.isUserSignedIn());
    }

    @Test (dataProvider = "AuthenticationUsers1", dataProviderClass = DataHelper.class)


}
