package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Dropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        WebElement selectValue = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectValue);
        //select.selectByVisibleText("Purple");
        //select.selectByValue("3");
        select.selectByIndex(1);

        boolean isMultiple =select.isMultiple();
        System.out.println(isMultiple);

        List<WebElement> allColors = select.getOptions();
        for (WebElement e: allColors
             ) {
            System.out.println(e.getText());

        }

        WebElement selectOne = driver.findElement(By.xpath("(//div[@id='selectOne']//child::div) [7]"));
        wait.until(ExpectedConditions.elementToBeClickable(selectOne)).click();
        WebElement MrValue = driver.findElement(By.xpath("//div[text()='Mr.']"));
        wait.until(ExpectedConditions.elementToBeClickable(MrValue)).click();
// get the first selected value from dropdown with getFirstSelectedOption().getText()
        Select selectCar = new Select(driver.findElement(By.id("cars")));
        selectCar.selectByVisibleText("Opel");
        String expect = selectCar.getFirstSelectedOption().getText();
        String actual ="Opel";
        if (expect.equals(actual)){
            System.out.println("TEST PASSED!!");
            System.out.println("TEST PASSED!!");
            System.out.println("TEST PASSED!!");
            System.out.println("TEST PASSED!!");
            System.out.println("TEST PASSED!!");
            System.out.println("TEST PASSED!!");
        } else{
            System.out.println("TEST FAILED!!");
        }

        System.out.println("***************************");
    //get all selected values from dropdown with method getAllSelectedOptions()
        Select multiCars = new Select(driver.findElement(By.id("cars")));
        multiCars.selectByVisibleText("Volvo");
        multiCars.selectByVisibleText("Saab");
        multiCars.selectByVisibleText("Opel");

        List<WebElement> carList = multiCars.getAllSelectedOptions();
        for (WebElement car : carList
             ) {
            System.out.println(car.getText());

        }








        Thread.sleep(3000);
        driver.quit();
    }
}
