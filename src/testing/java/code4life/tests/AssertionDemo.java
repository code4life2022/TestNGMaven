package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertionDemo {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown(){


        driver.quit();
    }

    @Test
    public void verifyTitle(){

        String actualTitle = "Swag Labs";

        Assert.assertEquals(actualTitle, driver.getTitle());

    }

    @Test
    public void verifyLoginBtn(){
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        Assert.assertNotEquals(2,5);
    }
}
