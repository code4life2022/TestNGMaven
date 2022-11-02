package code4life.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportPriorityXML {

    @Test(priority = 1)
    public void login(){
        System.out.println("TEST ONE");


        Assert.assertEquals(2, 4);
    }

    @Test(priority = 2)
    public void title(){
        System.out.println("TEST TWO");
    }
    @Test(priority = 3)
    public void home(){
        System.out.println("TEST THREE");
    }
    @Test(priority = 4)
    public void terminate(){
        System.out.println("TEST FOUR");
    }
}
