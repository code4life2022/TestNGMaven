package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxRadioTextBox {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement elements = driver.findElement(By.xpath("(//div[@id='app']//child::div) [7]"));
        wait.until(ExpectedConditions.elementToBeClickable(elements)).click();
        WebElement textBoxField = driver.findElement(By.xpath("//span[text()='Text Box']"));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxField)).click();
        WebElement fullNameField = driver.findElement(By.cssSelector("#userName"));
        wait.until(ExpectedConditions.visibilityOf(fullNameField)).sendKeys("John Doe");
        WebElement email = driver.findElement(By.cssSelector("#userEmail"));
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("John.doe@gmail.com");
        executor.executeScript("window.scrollBy(0,500)");
        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
//
//        //checkbox section
//        WebElement checkbox = driver.findElement(By.xpath("//span[text()='Check Box']"));
//        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
//        WebElement homeDropdown = driver.findElement(By.xpath("(//div[@id='tree-node']//preceding::button) [4]"));
//        wait.until(ExpectedConditions.elementToBeClickable(homeDropdown)).click();
//        WebElement desktopCheckbox = driver.findElement(By.xpath("//input[@id='tree-node-desktop']//parent::label//child::span[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(desktopCheckbox)).click();
//        WebElement docCheckbox = driver.findElement(By.xpath("//input[@id='tree-node-documents']//parent::label//child::span[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(docCheckbox)).click();

        //radio button section
        WebElement radioBtn = driver.findElement(By.xpath("//span[text()='Radio Button']"));
        //wait.until(ExpectedConditions.elementToBeClickable(radioBtn)).click();
        WebElement yesRadio = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        executor.executeScript("arguments[0].click();", yesRadio);

        WebElement noRadioButton = driver.findElement(By.xpath("//input[@id='noRadio']"));
        if (!noRadioButton.isEnabled()){
            System.out.println("Great!! Radio button is not enabled!!!! ");
        } else {
            System.out.println("It's bad !! Radio button is enabled!");
        }








        Thread.sleep(2000);
        driver.quit();

    }
}
