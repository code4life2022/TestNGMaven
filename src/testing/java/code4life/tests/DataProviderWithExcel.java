package code4life.tests;

import code4life.base.TestBase;
import code4life.utilities.Driver;
import code4life.utilities.ExcelUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderWithExcel extends TestBase {
    WebDriver driver;


//    @BeforeMethod
//    public void setup(){
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");
//    }
//
//    @AfterMethod
//    public void teardown(){
//
//
//        driver.quit();
//    }


    @DataProvider(name = "provider")
    public Object [][] testDataProvider(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"standard_user", "secret_sauce"},
                {"standard_user", "secret_sauce"},



        };



    }

    @Test(dataProvider = "provider")

    public void testMultipleLogin(String username   , String password){

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

    }
    @Test (dataProvider = "credentialFromExcel")
    public void loginTestWithExcel( String username, String password) throws IOException {

        Driver.getDriver().findElement(By.id("user-name")).sendKeys(username);
        Driver.getDriver().findElement(By.id("password")).sendKeys(password);
        Driver.getDriver().findElement(By.id("login-button")).click();

    }

    @DataProvider
    public Object [][] credentialFromExcel() throws IOException {
        ExcelUtil utility = new ExcelUtil("Book2.xlsx", "Sheet1");

        return utility.return2DArray();
    }




}
