import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class HttpVerification {

    @Test
    public void httpVerify () throws URISyntaxException, IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Implicit Wait in Selenium
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        System.out.println(connection.getResponseCode());

    }
}
