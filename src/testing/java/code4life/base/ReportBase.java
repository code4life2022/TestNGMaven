package code4life.base;

import code4life.utilities.ConfigurationReader;
import code4life.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class ReportBase {
    protected ExtentReports extent;
    ExtentSparkReporter spark;
    protected ExtentTest test;

    @BeforeTest
    public void setupTest() throws IOException {

        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");


        String URL = ConfigurationReader.getProperties("url2");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(URL);
        String reportPath = "";
        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {

            //System.getProperty("user.dir")+"/test-output/screenshots"+name+".png";
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";


        } else {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";

        }





    }


    @AfterTest
    public void tearDownTest() {
        extent.flush();
        Driver.closeDriver();

    }

}
