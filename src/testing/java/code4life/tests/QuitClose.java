package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class QuitClose {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        WebElement name = driver.findElement(By.name("password"));
        name.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        WebElement link = driver.findElement(By.linkText("Sauce Labs Bike Light"));
        link.click();
        driver.navigate().back();

        WebElement partialLink = driver.findElement(By.partialLinkText("Sauce Labs "));

        partialLink.click();
        driver.navigate().back();
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (WebElement eachLink: allLinks) {

            System.out.println(eachLink.getText() + " - "+ eachLink.getAttribute("href"));

        }

        List<WebElement > classSize = driver.findElements(By.className("inventory_item"));
        System.out.println(classSize.size());

        Thread.sleep(2000);



        driver.quit();




    }
}
