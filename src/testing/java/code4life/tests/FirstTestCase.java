package code4life.tests;

import org.testng.annotations.Test;

public class FirstTestCase {
    @Test
    public void setup(){
        System.out.println("opening browser");

    }
    @Test
    public void login(){
        System.out.println("I'm logging in ");
    }

    @Test
    public void teardown(){
        System.out.println("closing browser");
    }
}
