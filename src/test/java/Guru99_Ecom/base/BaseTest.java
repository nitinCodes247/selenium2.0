package Guru99_Ecom.base;

import Guru99_Ecom.pageobjects.HomePage;
import Guru99_Ecom.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    protected HomePage homePage;
    public WebDriver setUp(){
        String browser = System.getProperty("browser", ConfigReader.get("browser"));
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else {
            throw new RuntimeException("Invalid Browser Used.");
        }
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public HomePage launchApplication(){
        driver = setUp();
        homePage = new HomePage(driver);
        homePage.landOnHomePage();
        return homePage;
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
