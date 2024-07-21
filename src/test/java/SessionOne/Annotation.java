package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

//@Test   // @Test annotation is to make all the public methods of this class to become test methods even if they are not annotated.
public class Annotation {
        private WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
        }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @Test
    public void testCase1(){
        System.out.println("test cas 1");
    }
    @Test
    public void testCase2(){
        System.out.println("test cas 2");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("afterTest");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("fterClass");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    
}
