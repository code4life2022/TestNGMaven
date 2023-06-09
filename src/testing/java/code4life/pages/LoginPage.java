package code4life.pages;

import code4life.base.BasePage;
import code4life.utilities.ConfigurationReader;
import code4life.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class LoginPage extends BasePage {




//    public LoginPage() throws IOException {
//
//        Driver.getDriver();
//    }

//    public LoginPage( ) throws IOException {
//        Driver.getDriver();
//
//
//    }

    By userName = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By userNameLists = By.xpath("//h4[text()='Accepted usernames are:']");
    By passwordList = By.xpath("//h4[text()='Password for all users:']");
    public LoginPage() throws IOException {
    }


    public void sendUsername(String UsName) throws IOException {
        Driver.getDriver().findElement(userName).sendKeys(UsName);


    }

    public void sendPassword(String pass) throws IOException {

      //  Driver.getDriver().findElement(password).sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(password))).sendKeys(pass);
    }

    public void clickLoginBtn () throws IOException {
        //Driver.getDriver().findElement(loginBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(loginBtn))).click();

    }

    public String returnUserNameLabelText() throws IOException {


       return wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().
               findElement(userNameLists))).getText();
    }

    public String returnPasswordLabelText() throws IOException {


        return wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().
                findElement(passwordList))).getText();
    }
    public void login(String username, String pass) throws IOException {
        wait.until(ExpectedConditions.visibilityOf(Driver.
                getDriver().findElement(userName))).sendKeys(username);

        wait.until(ExpectedConditions.visibilityOf(Driver.
                getDriver().findElement(password))).sendKeys(pass);

    }
    public void login() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(Driver.
                getDriver().findElement(userName))).sendKeys(ConfigurationReader.getProperties("user"));

        wait.until(ExpectedConditions.visibilityOf(Driver.
                getDriver().findElement(password))).sendKeys(ConfigurationReader.getProperties("pass"));

    }


}
