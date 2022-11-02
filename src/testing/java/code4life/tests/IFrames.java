package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com");
        WebElement linkToIframe = driver.findElement
                (By.xpath("//*[contains(text(),'Alerts, Frame & Windows')]"));
        javascriptExecutor.executeScript("arguments[0].click();", linkToIframe);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("iframe size  = "+ size);
        WebElement frames = driver.findElement(By.xpath("(//li[@id='item-2']) [2]"));
        javascriptExecutor.executeScript("arguments[0].click();", frames);
        WebElement firstIFrame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(firstIFrame);
        //driver.switchTo().frame("frame1");
        WebElement iframeText = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println(iframeText.getText());
        driver.switchTo().defaultContent();
        WebElement browserWin = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
       // wait.until(ExpectedConditions.elementToBeClickable(browserWin)).click();


        Thread.sleep(2000);
        driver.quit();

    }
}
