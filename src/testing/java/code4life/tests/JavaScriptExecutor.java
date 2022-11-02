package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement window = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        js.executeScript("arguments[0].click();", window);
        WebElement browserWin = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        //wait.until(ExpectedConditions.elementToBeClickable(browserWin)).click();
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        driver.quit();

    }
}
