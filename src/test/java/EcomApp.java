import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class EcomApp {

    @Test
    public void addToCart(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Implicit Wait in Selenium
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        List<String> productList = Arrays.asList("Cucumber","Tomato","Banana");
        List<WebElement> availableProducts = driver.findElements(By.cssSelector("h4.product-name"));

        int count=0;
        for(int i=0; i<availableProducts.size(); i++){
            String productName = availableProducts.get(i).getText().split(" ")[0];
            if(productList.contains(productName)){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                count++;
            }
            if(count==productList.size()) break;
        }
    }
}
