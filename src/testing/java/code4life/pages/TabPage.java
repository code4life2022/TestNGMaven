package code4life.pages;
import code4life.base.BasePage;
import code4life.utilities.BrowserUtils;
import code4life.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class TabPage  extends BasePage {
//   public   WebDriver driver;
//
//
//    public TabPage(WebDriver driver) {
//        this.driver = driver;
//    }


    By menu = By.cssSelector("#react-burger-menu-btn");
    By about = By.id("about_sidebar_link");

    public TabPage() throws IOException {
    }


    public void clickAboutButton() throws IOException {
        BrowserUtils.wait(2);
        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(about))).click();
       // Driver.getDriver().findElement(about).click();
    }


    public void clickMenu() throws IOException {
       BrowserUtils.wait(2);
      wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(menu))).click();
        //Driver.getDriver().findElement(menu).click();

    }

}
