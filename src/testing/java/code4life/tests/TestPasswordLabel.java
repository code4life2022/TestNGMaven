package code4life.tests;

import code4life.base.TestBase;

import code4life.pages.LoginPage;
import code4life.utilities.BrowserUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPasswordLabel extends TestBase {

    @Test
    public void verifyPasswordLabel() throws IOException {
        ExtentTest test = extent.createTest("Verify text box");
        test.log(Status.PASS, "Text box passed");
        test.pass("Text Box test passed with Test.pass");
        test.info("Text box being tested test.info");
        LoginPage login = new LoginPage();

        String userNameLabel = "Password for all users:";
        Assert.assertEquals(userNameLabel, login.returnPasswordLabelText());
        BrowserUtils.wait(3);

        test.pass("password label successfully verified ! ");
    }
}
