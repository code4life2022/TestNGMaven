package code4life.pages;

import code4life.base.BasePage;
import code4life.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElementsPage  extends BasePage {
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

    public ElementsPage() throws IOException {
    }

    By elementBtn = By.xpath("(//div[@id='app']//child::div) [7]");
    By textBox = By.xpath("//span[text()='Text Box']");
    By fullName = By.cssSelector("#userName");
    By email = By.cssSelector("#userEmail");
    By submitBtn = By.cssSelector("#submit");

    By nameText = By.id("name");
    By emailText = By.id("email");

    public String returnName() throws IOException {
      String name =   wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(nameText))).getText();

      return name;

    }

    public String returnEmail() throws IOException {
        String email1 =   wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(emailText))).getText();

        return email1;

    }
    By list = By.xpath("//label[@class='form-label']");

    public void sendFullNameText(String name ) throws IOException {
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().
                findElement(fullName))).sendKeys(name);
    }
    public void sendEmailValue(String ema) throws IOException {
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().
                findElement(email))).sendKeys(ema);
    }

    public void clickSubmit() throws IOException {
        executor.executeScript("window.scrollBy(0, 500)");
        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver()
                .findElement(submitBtn))).click();
    }

    public void clickElements(){
        wait.until(ExpectedConditions.elementToBeClickable(elementBtn)).click();
    }

    public void clickTextBox(){
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
    }






    public List<String> getTextWebElements() throws IOException {
        List<WebElement> elements = Driver.getDriver().findElements(list);
        List<String> textValues = new ArrayList<>();
        for (WebElement element: elements) {
            textValues.add(element.getText());


        }
        return textValues;
    }
}
