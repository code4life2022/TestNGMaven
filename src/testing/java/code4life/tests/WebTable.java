package code4life.tests;

import code4life.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class WebTable {
    WebDriver driver;
    @BeforeMethod
    public void beforeSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("************************");
    }
    @AfterMethod
    public void afterSetup(){
        BrowserUtils.wait(4);
        driver.quit();

    }

    @Test
    public void printEntireTableData(){
        List<WebElement> allTableData = driver.findElements(By.xpath("//table[1]/tbody/tr/td"));
        for (WebElement cellData:allTableData
             ) {
            System.out.println(cellData.getText());

        }

    }

    @Test
    public void findColumnAndRowSize(){
        List<WebElement> rowSize = driver.findElements(By.xpath("//table[1]/tbody/tr/td[3]"));
        System.out.println("Row Size = " + rowSize.size());

        Assert.assertEquals(4, rowSize.size());

        List<WebElement> columnSize = driver.findElements(By.xpath("//table[1]/tbody/tr[3]/td"));

        System.out.println("Column Size = "+ columnSize.size());
        Assert.assertEquals(6, columnSize.size());







    }

    @Test
    public void printDataOnlyFromColumn(){
        List<WebElement> dataFromColumn = driver.findElements(By.xpath("//table[1]/tbody/tr/td[1]"));
       List<String> expect  = Arrays.asList("Smith", "Bach", "Doe", "Conway");


        for (WebElement e:dataFromColumn
             ) {
            System.out.println(e.getText());

        }


        Assert.assertEquals(BrowserUtils.getTextFromWebElements(dataFromColumn), expect);
    }

    @Test
    public void printDataFromRow(){
        ////table[1]/tbody//td[text()='jdoe@hotmail.com']
        List<WebElement> dataFromRow = driver.findElements(By.xpath("//table[1]/tbody/tr[1]/td"));
        for (WebElement cellRow: dataFromRow
             ) {
            System.out.println(cellRow.getText());

        }

    }

    @Test
    public void deleteRowBasedOnEmail(){
        WebElement delete = driver.findElement(By.xpath("//table[1]/tbody//td[text()='jdoe@hotmail.com']//following-sibling::td[3]/a[2]"));
        delete.click();
           List<WebElement> email = driver.findElements(By.xpath("//table[1]/tbody//td[text()='jdoe@hotmail.com']"));


            Assert.assertEquals(1, email.size());


    }

    @Test

    public void returnDataBasedOnRowAndColumn(){

        int rowNo =4;
        int columnNo=5;

        WebElement cellData = driver.findElement(By.xpath("//table[1]/tbody/tr["+rowNo+"]/td["+columnNo+"]"));
        System.out.println(cellData.getText());
        Assert.assertEquals("http://www.timconway.com", cellData.getText());

    }








}
