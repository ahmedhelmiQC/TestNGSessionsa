package SessionOne;

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
    @AfterMethod(alwaysRun = true)
    public void quite(){
        driver.quit();
    }
}
