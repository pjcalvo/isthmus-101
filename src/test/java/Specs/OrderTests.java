package Specs;

import Helpers.DriverHelper;
import Model.User;
import Pages.ProductPage;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTests extends SpecsBaseClass{

    @Test
    public void PlaceOrder() {

        productPage.GoTo("acuvue");

        /* complete the assertion

        Assert.assertEquals(productPage.productTitle,
                "ACUVUE® VITA™ for Astigmatism");

        */
    }
}
