package SessionOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Dependencies {
    private WebDriver driver;
   @BeforeTest
    public void befouretest(){
        System.out.println("before test");
    }
    @BeforeClass
    public void Setup(){
        driver= new EdgeDriver();
        driver.navigate().to("https://ashraaf7.github.io/AA-Practice-Test-Automation");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void RegisterTC(){
        System.out.println("RegisterTC");
        //Assert.fail();
    }

    @Test (dependsOnMethods = "RegisterTC" )
    public void LoginTCRun(){
        System.out.println("RegisterTC");
    }
    @Test (dependsOnMethods = "RegisterTC")
    public void LoginTC(){
        System.out.println("LoginTC");
    }
    @AfterClass
    public void Quite(){
        driver.quit();
    }
}
