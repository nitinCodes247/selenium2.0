package Guru99_Ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MobileListPage {

    @Test(description = "Verify item in Mobile List page can be sorted by 'Name'")
    public void verifyNameSortingMobilePage() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        driver.get("https://live.techpanda.org/");

        String pageTitle = driver.findElement(By.xpath("//div[@class='page-title']/h2")).getText();
        Assert.assertTrue(pageTitle.contains("THIS IS DEMO SITE"));

        driver.findElement(By.cssSelector("a[href*='mobile.html']")).click();
        pageTitle = driver.findElement(By.cssSelector(".page-title h1")).getText();
        Assert.assertEquals(pageTitle,"MOBILE");

        Select sortBy = new Select(driver.findElement(By.xpath("(//select[@title='Sort By'])[1]")));
        sortBy.selectByVisibleText("Name");

        List<WebElement> productNameElements = driver.findElements(By.cssSelector("h2.product-name"));
        List<String> productNames = productNameElements.stream().map(WebElement::getText).toList();
        List<String> sortedProductNames = productNames.stream().sorted().toList();

        Assert.assertEquals(sortedProductNames, productNames);

        driver.quit();
    }
}
