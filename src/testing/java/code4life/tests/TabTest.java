package code4life.tests;

import code4life.base.TestBase;
import code4life.pages.LoginPage;
import code4life.pages.TabPage;
import code4life.utilities.BrowserUtils;
import code4life.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.IOException;

public class TabTest extends TestBase {

    @Test
    public void TestTabMenu() throws IOException {
        //test = reports.createTest("Verify tab test");
        LoginPage page = new LoginPage();
        page.sendUsername(ConfigurationReader.getProperties("user"));
        page.sendPassword(ConfigurationReader.getProperties("pass"));
        page.clickLoginBtn();
        TabPage tab = new TabPage();
        tab.clickMenu();
        tab.clickAboutButton();
        //test.pass("tab test successfully passed ! ");
        BrowserUtils.wait(3);
    }
}
