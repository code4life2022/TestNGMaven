package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        WebElement simAlert = driver.findElement(By.id("alertButton"));
        simAlert.click();
        Alert simpleAlert = driver.switchTo().alert();
        String simExpect = simpleAlert.getText();
        Thread.sleep(1000);
        simpleAlert.accept();
        String simActual = "You clicked a button";
        if (simExpect.equals(simActual)){
            System.out.println("Text is matched!! Passed!!");

        } else {
            System.out.println("Text is not matched. Failed!!");
        }

        WebElement confirm = driver.findElement(By.id("confirmButton"));
        confirm.click();
        Alert conAlert = driver.switchTo().alert();
        String conExpectText = conAlert.getText();
        String confirmActualText = "Do you confirm action?";
        conAlert.accept();
        if (conExpectText.equals(confirmActualText)){
            System.out.println("confirmed!! Passed!!");

        } else {
            System.out.println("Not confirmed. Failed!!");
        }


        WebElement promptBtn = driver.findElement(By.id("promtButton"));
        promptBtn.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Mike");
        promptAlert.accept();
        WebElement promptText = driver.findElement(By.id("promptResult"));
        String promptExpText = promptText.getText();
        if (promptExpText.contains("Mike")){
            System.out.println("Mike is found!! Passed");
        } else {
            System.out.println("Mike not found, Failed");
        }















        Thread.sleep(2000);
        driver.quit();


    }
}
