package code4life.tests;

import code4life.base.TestBase;
import code4life.pages.LoginPage;
import code4life.utilities.BrowserUtils;
import code4life.utilities.ConfigurationReader;
import code4life.utilities.Driver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLogin extends TestBase {

    @Test
    public void testLoginFunctionality () throws IOException {

        ExtentTest test = extent.createTest("Verify text box");
        test.log(Status.PASS, "Text box passed");
        test.pass("Text Box test passed with Test.pass");
        test.info("Text box being tested test.info");
        String user = ConfigurationReader.getProperties("user");
        String pass = ConfigurationReader.getProperties("pass");
        System.out.println("username = " + user);
        System.out.println("password = "+ pass);

        LoginPage loginPage = new LoginPage();
        loginPage.sendUsername(ConfigurationReader.getProperties("user"));
        loginPage.sendPassword(ConfigurationReader.getProperties("pass"));
        loginPage.clickLoginBtn();
        BrowserUtils.wait(2);

        //BrowserUtils.getScreenshot("Title");
        String actual = "PRODUCTS";
        Assert.assertEquals(actual, Driver.getDriver().findElement(By.xpath("//span[text()='Products']")).getText());
        test.pass("login test successfully passed ! ");

//        PageBase pb = new PageBase(driver);
//        pb.openTab("Resources");

    }
}
