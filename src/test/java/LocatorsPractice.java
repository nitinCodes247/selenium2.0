import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocatorsPractice {
    @Test
    public void locators() throws InterruptedException {
        String name = "Nitin";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Implicit Wait in Selenium
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //id locator
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        //name locator
        driver.findElement(By.name("inputPassword")).sendKeys("Nc123");
        //className locator
        driver.findElement(By.className("signInBtn")).click();
        //css locator
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        //LinkText
        driver.findElement(By.linkText("Forgot your password?")).click();

        //xpath
        driver.findElement(By.xpath("//input[@placeholder='Name']"))
                .sendKeys(name);

        driver.findElement(By.cssSelector("input[placeholder='Email']"))
                .sendKeys("john.doe@example.com");

        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).
                sendKeys("john.doe@example.com");

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.cssSelector(".go-to-login-btn")).click();

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);

        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxOne")).click();

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(2000);
        String actualText = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actualText,"You are successfully logged in.");

        String actualGreeting = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        Assert.assertEquals(actualGreeting,"Hello "+name+",");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        driver.quit();
    }
}
