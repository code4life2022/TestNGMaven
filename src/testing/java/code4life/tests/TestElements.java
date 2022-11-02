package code4life.tests;

import code4life.base.TestBase;
import code4life.pages.ElementsPage;
import code4life.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestElements extends TestBase {
    ElementsPage e = new ElementsPage();

    public TestElements() throws IOException {
    }

    @Test (priority = 1 , groups = "fun")
    public void testTextBoxLabels() throws IOException {
       // ElementsPage e = new ElementsPage();
        BrowserUtils.wait(1);
        e.clickElements();
        e.clickTextBox();

        List<String > labels = Arrays.asList("Full Name", "Email", "Current Address", "Permanent Address");

        System.out.println(e.getTextWebElements());
        Assert.assertEquals(e.getTextWebElements(), labels);
    }


    @Test (priority =2 ,groups= "fun")
    public void verifyTextInputs() throws IOException {

        e.clickElements();
        e.clickTextBox();
        e.sendFullNameText("Derek Alston");
        e.sendEmailValue("Derek.alston@mgail.com");
        e.clickSubmit();
        String actualName = "Name:Derek Alston";
        Assert.assertEquals(actualName, e.returnName());
        String actualEmail = "Email:Derek.alston@mgail.com";
        Assert.assertEquals(actualEmail, e.returnEmail());
    }


}
