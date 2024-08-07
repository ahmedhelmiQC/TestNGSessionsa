package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Assertion {
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @BeforeMethod
    public void Setup(){
        driver= new EdgeDriver();
        driver.navigate().to("https://ashraaf7.github.io/AA-Practice-Test-Automation");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test (priority = 2 )
    public void HardassertValidloginTestcase(){
        driver.findElement(By.id("inputUsername")).sendKeys("2"); // username
        driver.findElement(By.id("inputPassword")).sendKeys("admin");   // password
        driver.findElement(By.id("loginButton")).click();  // clicklogin

        driver.switchTo().alert().accept();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

        Assert.assertFalse(expected, "1");
       // Assert.assertFalse(driver.getCurrentUrl(), "www.google.com","2");

    }
    @Test (priority = 1 )
    public void SoftassertValidloginTestcase(){
        driver.findElement(By.id("inputUsername")).sendKeys("2"); // username
        driver.findElement(By.id("inputPassword")).sendKeys("admin");   // password
        driver.findElement(By.id("loginButton")).click();  // clicklogin

        driver.switchTo().alert().accept();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        softAssert = new SoftAssert();
        softAssert.assertFalse(expected, "1");
        //softAssert.assertFalse(driver.getCurrentUrl(), "www.google.com","2");
        softAssert.assertAll();

    }
    @Test (priority = 3 , enabled = false)
    public void InvalidloginTestcase(){
        driver.findElement(By.id("inputUsername")).sendKeys("2"); // username
        driver.findElement(By.id("inputPassword")).sendKeys("admin");   // password
        driver.findElement(By.id("loginButton")).click();  // clicklogin

        driver.switchTo().alert().accept();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        Assert.assertFalse(expected);
    }
    @Ignore
    @Test (priority = 4)
    public void InvalidloginTestcase2(){
        driver.findElement(By.id("inputUsername")).sendKeys("2"); // username
        driver.findElement(By.id("inputPassword")).sendKeys("admin");   // password
        driver.findElement(By.id("loginButton")).click();  // clicklogin

        driver.switchTo().alert().accept();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        Assert.assertTrue(expected);
    }

    @AfterMethod
    public void quite(){
        driver.quit();
    }

}
