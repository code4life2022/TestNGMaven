package code4life.tests;

import org.testng.annotations.Test;

public class GroupingTestCases {
// <groups>
//            <run>
//                <include name="smoke"></include>
//            </run>
//        </groups>
//       <classes>
//           <class name="code4life.testNG.GroupingTestCases"></class>
//       </classes>

    @Test(groups = "smoke")
    public void testA(){
        System.out.println("This is test A - smoke");

    }
    @Test (groups = "smoke")
    public void testB(){
        System.out.println("This is test B  - smoke");
    }
    @Test(groups = "smoke")
    public void testC(){
        System.out.println("This is test C - smoke");
    }


    @Test(groups = "regression")
    public void testD(){
        System.out.println("This is test D- regression suite");
    }
    @Test(groups = "regression")
    public void testE(){
        System.out.println("This is test E - regression suite");
    }
    @Test(groups = "regression")
    public void testF(){
        System.out.println("This is test F- regression suite ");
    }

}
