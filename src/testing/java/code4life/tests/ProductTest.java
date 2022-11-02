package code4life.tests;

import code4life.base.TestBase;
import code4life.pages.LoginPage;
import code4life.pages.Products;
import code4life.utilities.BrowserUtils;
import code4life.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductTest extends TestBase {


    @Test
    public void verifyCarFunctionality () throws IOException {

        LoginPage login = new LoginPage();
        login.sendUsername(ConfigurationReader.getProperties("user"));
        login.sendPassword(ConfigurationReader.getProperties("pass"));
        login.clickLoginBtn();
        Products products = new Products();
        products.clickPack();
        products.clickBoldShirt();
        products.clickBike();
        products.clickCart();
        BrowserUtils.getScreenshot("carts");
        Assert.assertEquals(3, products.returnCarSize());
    }
}
