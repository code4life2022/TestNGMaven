package code4life.tests;

import code4life.base.TestBase;
import code4life.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestUserNameLabel extends TestBase {



    @Test
    public void verifyUserNameList() throws IOException {

        LoginPage login = new LoginPage();
        String userNameLabel = "Accepted usernames are:";
        Assert.assertEquals(userNameLabel, login.returnUserNameLabelText());
    }





}
