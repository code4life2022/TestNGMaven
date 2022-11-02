package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,700)");
        WebElement interactions = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(interactions).click().build().perform();
        executor.executeScript("window.scrollBy(0,500)");
        WebElement droppable = driver.findElement(By.xpath("//span[text()='Droppable']"));
        actions.moveToElement(droppable).click().build().perform();
        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropMe = driver.findElement(By.id("droppable"));
        String color = dropMe.getCssValue("background-color");
        System.out.println("Before drag and drop = "+ color);
        actions.dragAndDrop(dragMe, dropMe).build().perform();

        String color2 = dropMe.getCssValue("background-color");
        System.out.println("After drag and drop = "+ color2);


        //Second way to do drag and drop
        WebElement accept = driver.findElement(By.id("droppableExample-tab-accept"));
        actions.moveToElement(accept).click().build().perform();
        WebElement acceptable = driver.findElement(By.xpath("//div[@id='acceptable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable']) [2]"));
        actions.clickAndHold(acceptable).moveToElement(dropHere).release().build().perform();

        //Type string in upper case and lower case

        WebElement elements = driver.findElement(By.xpath("//*[text()='Elements']"));
        actions.click(elements).build().perform();
        WebElement textBox = driver.findElement(By.xpath("//*[text()='Text Box']"));
        actions.click(textBox).build().perform();
        WebElement fullName = driver.findElement(By.id("userName"));

        actions.keyDown(fullName, Keys.SHIFT)
                        .sendKeys(fullName, "hillary clinton").build().perform();
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        actions.keyDown(currentAddress, Keys.SHIFT)
                        .sendKeys(currentAddress, "This is my current address  \n")
                                .keyUp(currentAddress, Keys.SHIFT)
                                        .sendKeys("Brendan court Troy New York ").doubleClick().contextClick()
                        .build().perform();




        Thread.sleep(5000);
        driver.quit();
    }
}
