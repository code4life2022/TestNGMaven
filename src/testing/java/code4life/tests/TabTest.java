package code4life.tests;

import code4life.base.TestBase;
import code4life.pages.LoginPage;
import code4life.pages.TabPage;
import code4life.utilities.BrowserUtils;
import code4life.utilities.ConfigurationReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class TabTest extends TestBase {

    @Test
    public void TestTabMenu() throws IOException {
        ExtentTest test = extent.createTest("Verify text box");
        test.log(Status.PASS, "Text box passed");
        test.pass("Text Box test passed with Test.pass");
        test.info("Text box being tested test.info");
        LoginPage page = new LoginPage();
        page.sendUsername(ConfigurationReader.getProperties("user"));
        page.sendPassword(ConfigurationReader.getProperties("pass"));
        page.clickLoginBtn();
        TabPage tab = new TabPage();
        tab.clickMenu();
        tab.clickAboutButton();
        test.pass("tab test successfully passed ! ");
        BrowserUtils.wait(3);
    }
}
