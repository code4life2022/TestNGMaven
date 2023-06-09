package code4life.tests;

import code4life.base.TestBase;
import code4life.utilities.Driver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTitle extends TestBase {

    @Test
    public void verifyTitle() throws IOException {
        ExtentTest test = extent.createTest("Verify text box");
        test.log(Status.PASS, "Text box passed");
        test.pass("Text Box test passed with Test.pass");
        test.info("Text box being tested test.info");

        Assert.assertEquals("Swag Labs", Driver.getDriver().getTitle());

        test.pass("title test successfully passed ! ");
    }
}
