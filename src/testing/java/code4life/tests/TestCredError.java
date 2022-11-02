package code4life.tests;

import code4life.pages.LPage;
import code4life.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCredError {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        System.out.println("This runs before every single @Test annotation");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown(){

        System.out.println("This runs after every single @Test annotation");
        driver.quit();
    }


@Test
    public void testLoginErrorText(){
    LPage l = new LPage(driver);
    String actualErrorText= "Epic sadface: Username and password do not match any user in this service";
    l.sendUserName("p");
    l.sendPassword("jsjs");
    l.clickLoginBtn();
    BrowserUtils.wait(1);
    Assert.assertEquals(l.returnErrorText(), actualErrorText);
}
}
