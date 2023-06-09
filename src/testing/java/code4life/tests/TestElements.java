package code4life.tests;

import code4life.base.ReportBase;
import code4life.base.TestBase;
import code4life.pages.ElementsPage;
import code4life.utilities.BrowserUtils;
import code4life.utilities.Driver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestElements extends ReportBase {
    ElementsPage e = new ElementsPage();

    public TestElements() throws IOException {
    }

    @Test ()
    public void testTextBoxLabels() throws IOException {
       // ElementsPage e = new ElementsPage();
        ExtentTest test = extent.createTest("Verify text box");

        test.info("Text box being tested test.info");
        BrowserUtils.wait(1);
        e.clickElements();
        e.clickTextBox();

        List<String > labels = Arrays.asList("Full Name", "Email", "Current Address", "Permanent Address");
       // List<String > labels = Arrays.asList("Full Name");
        System.out.println(e.getTextWebElements());
       // Assert.assertEquals(e.getTextWebElements(), labels);
        if (e.getTextWebElements().equals(labels)){
            test.pass("Test Box label successfully verified!!");
        } else {
            test.fail("Test Box label verification failed. ");
        }


    }


    @Test ()
    public void verifyTextInputs() throws IOException {
        ExtentTest test = extent.createTest("Verify Text Input");

        e.clickElements();
        e.clickTextBox();
        e.sendFullNameText("Derek Alston");
        e.sendEmailValue("Derek.alston@mgail.com");
        e.clickSubmit();
        //Assert.assertEquals(actualName, e.returnName());
        String actualEmail = "Email:Derek.alston@mgail.com";

        System.out.println("expect email: "+ e.returnEmail());
        System.out.println("Actual email: "+ actualEmail);
        if (e.returnEmail().equals(actualEmail)){
            test.pass("Test input successfully verified!!");
        } else {
            test.fail(BrowserUtils.getScreenshot("Text input")+"Test input verification failed. ");
        }

     Assert.assertEquals(actualEmail, e.returnEmail());
    }

    @Test
    public void testTitle() throws IOException {
        ExtentTest test = extent.createTest("Verify title");



        if (Driver.getDriver().getTitle().equals("ToolsQA")){
            test.pass("Test input successfully verified!!");
        } else {
            test.fail(BrowserUtils.getScreenshot("Title")+"Test input verification failed. ");
        }
        Assert.assertEquals("ToolsQA", Driver.getDriver().getTitle());
    }



}
