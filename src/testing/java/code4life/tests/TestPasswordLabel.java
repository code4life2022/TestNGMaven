package code4life.tests;

import code4life.base.TestBase;
import code4life.pages.LoginPage;
import code4life.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPasswordLabel extends TestBase {

    @Test
    public void verifyPasswordLabel() throws IOException {
        test = reports.createTest("verify password label");
        LoginPage login = new LoginPage();
        String userNameLabel = "Passwofor all users:";
        Assert.assertEquals(userNameLabel, login.returnPasswordLabelText());
        BrowserUtils.wait(3);

        test.pass("password label successfully verified ! ");
    }
}
