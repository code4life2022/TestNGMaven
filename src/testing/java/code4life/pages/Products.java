package code4life.pages;

import code4life.base.BasePage;
import code4life.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class Products extends BasePage {


    By backPack = By.id("add-to-cart-sauce-labs-backpack");
    By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    By boldTShirt =By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By cart = By.id("shopping_cart_container");
    
    By st1 = By.id("add-to-cart-sauce-labs-backpack");
    By st2 = By.id("add-to-cart-sauce-labs-bike-light");
    By st3 =By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By st4 = By.id("shopping_cart_container");
    
    

    By cartItems = By.xpath("//div[@class='cart_item']");

    By productsText = By.xpath("//span[text()='Products']");

    public String returnProductText() throws IOException {
    String text=    wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(productsText))).getText();



        return text;
    }

    public Products() throws IOException {
    }


    public void clickPack(){
        wait.until(ExpectedConditions.elementToBeClickable(backPack)).click();

    }

    public void clickBike(){
        wait.until(ExpectedConditions.elementToBeClickable(bikeLight)).click();
    }

    public void clickBoldShirt(){
        wait.until(ExpectedConditions.elementToBeClickable(boldTShirt)).click();
    }

    public void clickCart() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(cart))).click();
    }

    public int returnCarSize () throws IOException {
        List<WebElement> cartList = Driver.getDriver().findElements(cartItems);

         int size = cartList.size();

         return size;
    }
}
