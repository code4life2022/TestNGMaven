package code4life.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

    public static void wait(int second){

        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }

    public static void waitHour(int second){
        int hour = second*3600;
        try {
            Thread.sleep(hour);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }

    public static List<String> getTextFromWebElements(List<WebElement> elements){

        List<String> textValues = new ArrayList<>();
        for (WebElement element: elements
             ) {
            textValues.add(element.getText());


        }
        return textValues;
    }

    public static String getScreenshot(String name ) throws IOException {

        Date d = new Date();
        name = d.toString().replace(":", "_").replace(" ", "_");

        //name = new Date().toString().replace(" ", "_").replace("-", "_")+name;
       // String path ="";
        //System.getProperty("user.dir")+"/test-output/screenshots"+name+".png";
      String path = "";
        System.out.println("OS name = "+ System.getProperty("os.name"));
        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")){
            System.out.println("mac sentence has been executed ");
             path = System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png";
        } else {
            path = System.getProperty("user.dir")+"\\test-output\\screenshots\\"+name+".png";
        }
        System.out.println("Screenshot is :     "+ path);
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);
        FileUtils.copyFile(source, destination);
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");
        System.out.println("Screenshot is :     ");


        return path;
    }
}
