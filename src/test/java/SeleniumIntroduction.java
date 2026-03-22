import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumIntroduction {

    @Test
    public void chromeInvoke(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
