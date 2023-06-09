package code4life.base;

import code4life.utilities.BrowserUtils;
import code4life.utilities.ConfigurationReader;
import code4life.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class TestBase {

    protected ExtentReports extent;
    ExtentSparkReporter spark;
    protected ExtentTest test;



    @BeforeTest
    public void setupTest() throws IOException {
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        extent = new ExtentReports();

        String reportPath = "";
        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {

            //System.getProperty("user.dir")+"/test-output/screenshots"+name+".png";
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";


        } else {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";

        }

        spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

        String URL = ConfigurationReader.getProperties("url2");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(URL);
       htmlReporter = new ExtentHtmlReporter(reportPath);
       reports.attachReporter(htmlReporter);
       htmlReporter.config().setReportName("HTML REPORT DEMO");


    }


    @AfterTest
    public void tearDownTest() {
        extent.flush();
        Driver.closeDriver();

    }

    @BeforeMethod
    public void setup() throws IOException {
    

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.saucedemo.com/");
         System.out.println("love "); System.out.println("love ");
         System.out.println("love ");
         System.out.println("love ");
         System.out.println("love ");
         System.out.println("love ");
         System.out.println("love "); System.out.println("love ");
         System.out.println("love ");
         System.out.println("love ");
         System.out.println("love ");

        String URL = ConfigurationReader.getProperties("url2");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(URL);


    }

   @AfterMethod(alwaysRun = true)
   public void teardown(ITestResult iTestResult) throws IOException {
       if (iTestResult.getStatus() == ITestResult.FAILURE) {
           String screenShotPath = BrowserUtils.getScreenshot(iTestResult.getName());
           test.fail(iTestResult.getName());
           test.addScreenCaptureFromPath(screenShotPath, "Failed");
           test.fail(iTestResult.getThrowable());
       }


       Driver.closeDriver();
   }
}

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
