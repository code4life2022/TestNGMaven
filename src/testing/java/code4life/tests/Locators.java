package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        //wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();
        WebElement link = driver.findElement(By.linkText("Sauce Labs Bike Light"));
        link.click();
        driver.navigate().back();
        Thread.sleep(1000);
        WebElement partialLink = driver.findElement(By.partialLinkText("Sauce Labs"));
        partialLink.click();
        driver.navigate().back();
        Thread.sleep(1000);

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for (WebElement eachLInk: allLinks) {
            System.out.println(eachLInk.getText() + " - " + eachLInk.getAttribute("href"));

        }

        List<WebElement > classSize = driver.findElements(By.className("inventory_item"));
        System.out.println(classSize.size());



        Thread.sleep(1500);
        driver.quit();
    }
}
