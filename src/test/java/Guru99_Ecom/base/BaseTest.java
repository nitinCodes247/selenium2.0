package Guru99_Ecom.base;

import Guru99_Ecom.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    protected HomePage homePage;
    public WebDriver initiateDriver(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public HomePage launchApplication(){
        driver = initiateDriver();
        homePage = new HomePage(driver);
        homePage.landOnHomePage();
        return homePage;
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
