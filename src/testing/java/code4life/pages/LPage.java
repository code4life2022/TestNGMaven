package code4life.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LPage {

    WebDriver driver;

    public LPage(WebDriver driver) {
        this.driver = driver;
    }

    By user = By.id("user-name");
    By pass =By.id("password");
    By loginBtn = By.id("login-button");

    By errorText = By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");

    public String returnErrorText(){

     String text =    driver.findElement(errorText).getText();

     return text;
    }

    public void sendUserName(String userTxt){
        driver.findElement(user).sendKeys(userTxt);

    }

    public void sendPassword(String passText){
        driver.findElement(pass).sendKeys(passText);

    }
    public void clickLoginBtn (){
        driver.findElement(loginBtn).click();
    }
}
