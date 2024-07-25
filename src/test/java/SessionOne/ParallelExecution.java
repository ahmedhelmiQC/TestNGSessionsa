package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.annotation.concurrent.ThreadSafe;
import java.time.Duration;

public class ParallelExecution {
    private SoftAssert softAssert;

    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    @Parameters (value = "browser")
    @BeforeMethod(alwaysRun = true)
    public void Setup(@Optional ("edge") String browser){
        switch (browser)
        {
            case "chrome":
               driverThreadLocal.set(new ChromeDriver());
                break;
            default:
             driverThreadLocal.set(new EdgeDriver());
                break;
        }
        driverThreadLocal.get().navigate().to("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Parameters({"username","password"})
    @Test (invocationCount = 3,threadPoolSize = 3)  // run 3 times in 3 thread
    public void ValidloginTestcase(@Optional("admin") String username , @Optional("admin") String password){
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(username); // username
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password);   // password
        driverThreadLocal.get().findElement(By.id("loginButton")).click();  // clicklogin

        //driver.switchTo().alert().accept();
        boolean expected = driverThreadLocal.get().getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

        Assert.assertTrue(expected, "2");

        // Assert.assertEquals(driver.getCurrentUrl(), "www.google.com","2");

    }


    @Test
    public void ValidloginTestcase2(@Optional("admin") String username , @Optional("admin") String password){
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(username); // username
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password);   // password
        driverThreadLocal.get().findElement(By.id("loginButton")).click();  // clicklogin

        //driver.switchTo().alert().accept();
       // boolean expected = driverThreadLocal.get().getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

        Assert.assertEquals(driverThreadLocal.get().getCurrentUrl(), "https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        // Assert.assertEquals(driver.getCurrentUrl(), "www.google.com","2");

    }
    @AfterMethod(alwaysRun = true)
    public void quite(){
     driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
