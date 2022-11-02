package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    WebDriver driver;


    @Test
    public void testSoftAssertion(){
        System.out.println("Opening up the browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Opening the website");
        driver.get("https://www.saucedemo.com/");

        SoftAssert softAssert = new SoftAssert();

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        String actual = "Swag Laboratory";
        System.out.println("verifying the title");


        softAssert.assertEquals(actual, driver.getTitle(), "The title did not match");
        softAssert.assertTrue(loginBtn.isEnabled());


        System.out.println("Terminating the program ");
        System.out.println("logging out and closing the browser");
        driver.quit();

        softAssert.assertAll();
    }
}
