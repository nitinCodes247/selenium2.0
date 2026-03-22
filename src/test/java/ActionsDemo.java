import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsDemo {

    @Test
    public void actionClassSelenium(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Implicit Wait in Selenium
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).
                click().keyDown(Keys.SHIFT).sendKeys("bluetooth speakers").keyUp(Keys.SHIFT).build().perform();
        action.moveToElement(driver.findElement(By.id("nav-search-submit-button"))).click().build().perform();

        //contextClick() ----> To right click
        //dragAndDrop(WebElement source, WebElement target) ----> to dragAndDrop an element

    }
}
