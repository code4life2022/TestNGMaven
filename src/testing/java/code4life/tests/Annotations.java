package code4life.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Annotations {
    WebDriver driver;

    @BeforeSuite
    public void runBeforeEntireSuite()
    {
        System.out.println("@BeforeSuite runs before entire test suite only once ");
    }


    @BeforeSuite
    public void runAfterEntireSuite(){

        System.out.println("@AfterSuite runs after entire test suite only once ");
    }
    @BeforeTest
    public void runBeforeTest(){
        System.out.println("This runs before entire test cases only once ");
    }

    @AfterTest
    public void runAfterTest(){

        System.out.println("This runs after entire test cases only once ");
    }

    @BeforeClass
    public void runBeforeClass(){

        System.out.println("This runs before the entire class only one time ");
    }

    @AfterClass
    public void runAfterClass(){
        System.out.println("This runs After the entire class only one time ");
    }

    @BeforeMethod
    public void driverSetup(){

        System.out.println("This runs before every single @Test annotation ");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("This runs after every single @Test annotation ");
        driver.quit();
    }

    @Test(priority = 1)
    public void testTitle(){
        System.out.println("This is test case 1 ");

        Assert.assertEquals("Swag Labs", driver.getTitle());

    }

    @Test(priority = 2)
    public void testLogin(){
        System.out.println("This is test case 2 ");




        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expect = driver.findElement(By.xpath("//span[text()='Products']")).getText();

        Assert.assertEquals("PRODUCTS", expect);


    }
}
