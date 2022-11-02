package code4life.Channel;

import code4life.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class View {

    WebDriver driver;
    @Test
    public void test(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/channel/UCjkLaaCxKf6sdU72GVRDjig");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Actions actions = new Actions(driver);
        BrowserUtils.wait(10);
        WebElement playAllBtn = driver.findElement(By.xpath("//div[@id='play-button']"));
      BrowserUtils.wait(5);

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", playAllBtn);
        //ait.until(ExpectedConditions.elementToBeClickable(playAllBtn)).click();
        actions.moveToElement(playAllBtn).click(playAllBtn).build().perform();


        //BrowserUtils.waitHour(2);

       // BrowserUtils.wait(50);



        //driver.quit();




    }
}
