package code4life.base;

import code4life.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class BasePage {

  public   WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
 public Actions actions = new Actions(Driver.getDriver());

    public BasePage() throws IOException {
    }
}
