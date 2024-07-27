package SessionOne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Parameterization {
    private WebDriver driver;
    private SoftAssert softAssert;
    //public Logger logger = LogManager.getLogger();

    @Parameters (value = "browser")
    @BeforeMethod(alwaysRun = true)
    public void Setup(@Optional ("edge") String browser){
        switch (browser)
        {
            case "chrome":
                driver= new ChromeDriver();
                break;
            default:
                driver= new EdgeDriver();
                break;
        }
       driver.navigate().to("https://ashraaf7.github.io/AA-Practice-Test-Automation");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Parameters({"username","password"})
    @Test
    public void ValidloginTestcase(@Optional("admin") String username , @Optional("admin") String password){
        driver.findElement(By.id("inputUsername")).sendKeys(username); // username
        driver.findElement(By.id("inputPassword")).sendKeys(password);   // password
        driver.findElement(By.id("loginButton")).click();  // clicklogin

        //driver.switchTo().alert().accept();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

        Assert.assertTrue(expected, "1");
        // Assert.assertEquals(driver.getCurrentUrl(), "www.google.com","2");

    }
    @Test
    public void ValidloginTestcase2(@Optional("admin") String username , @Optional("admin") String password){
        LogUtility.LOGGER.info("Test Case Started");
        driver.findElement(By.id("inputUsername")).sendKeys(username); // username
        LogUtility.LOGGER.info("username: admin written");
        driver.findElement(By.id("inputPassword")).sendKeys(password);   // password
        LogUtility.LOGGER.info("password:admin written");
        driver.findElement(By.id("loginButton")).click();  // clicklogin
        LogUtility.LOGGER.info("click on button");

        //driver.switchTo().alert().accept();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

        Assert.assertTrue(expected, "1");
        // Assert.assertEquals(driver.getCurrentUrl(), "www.google.com","2");

    }
    @AfterMethod(alwaysRun = true)
    public void quite(){
        driver.quit();
    }
}
