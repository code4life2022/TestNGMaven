package code4life.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/code4life/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.navigate().to("https://amazon.com");
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();

        Thread.sleep(1000);
        driver.navigate().refresh();

        driver.quit();
    }
}
