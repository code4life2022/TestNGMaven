package code4life.tests;

import code4life.base.TestBase;
import code4life.pages.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestUserNameLabel extends TestBase {



    @Test
    public void verifyUserNameList() throws IOException {
        ExtentTest test = extent.createTest("Verify text box");
        test.log(Status.PASS, "Text box passed");
        test.pass("Text Box test passed with Test.pass");
        test.info("Text box being tested test.info");

        LoginPage login = new LoginPage();
        String userNameLabel = "Accepted usernames are:";
        Assert.assertEquals(userNameLabel, login.returnUserNameLabelText());

        test.pass("login test successfully passed ! ");
    }





}
