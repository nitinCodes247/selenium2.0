import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserNavs {

    @Test
    public void windowActivities() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://google.com");
        driver.navigate().to("https://rekhta.org");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
    }
}
