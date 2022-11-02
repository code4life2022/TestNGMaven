package code4life.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public synchronized  static WebDriver getDriver() throws IOException {
        if (driver==null){
            String browser = ConfigurationReader.getProperties("browser").toLowerCase();
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;


                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default:
                    throw  new RuntimeException("Wrong browser name");
            }
        }

        return driver;


    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver = null;

      }


    }
}
