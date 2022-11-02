package code4life.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency {

    @Test
    public void openURL(){
        Assert.assertEquals(2, 2);
        System.out.println("Opening up the URL");
    }

    @Test(dependsOnMethods = "openURL")
    public void login(){
        Assert.assertEquals(5, 5);
        System.out.println("Logging into the website");
    }

    @Test(dependsOnMethods = "login")
    public void clickOnMainMenu(){
        System.out.println("clicking on Main Menu ");
    }

    @Test (dependsOnMethods = "login")
    public void logOut(){
        System.out.println("Logging out of the page");
    }
}
