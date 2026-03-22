import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDowns {

    @Test
    public void dropDownPractice(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Implicit Wait in Selenium
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //<select> tags are for static dropdowns
        WebElement staticDropdownElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select staticDropdown = new Select(staticDropdownElement);

        staticDropdown.selectByIndex(3);
        System.out.println(staticDropdown.getFirstSelectedOption().getText());

        staticDropdown.selectByVisibleText("AED");
        System.out.println(staticDropdown.getFirstSelectedOption().getText());

        staticDropdown.selectByValue("INR");
        System.out.println(staticDropdown.getFirstSelectedOption().getText());

        //Updated Dropdowns
        driver.findElement(By.id("divpaxinfo")).click();
        for(int i=0; i<4; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //Dynamic Dropdowns
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).click();

        //Auto-Suggest Dropdowns
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item"));
        for(WebElement option: options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
    }

    @Test(description = "End to End")
    public void endToEnd(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nitin\\Desktop\\IT2\\Codes\\Selenium2.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Implicit Wait in Selenium
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Select Country
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item"));
        for(WebElement option: options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }

        //Select Round Trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        //Select the Start & Destination
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).click();

        //Select the Journey Dates
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        driver.findElement(By.cssSelector(".ui-state-active")).click();

        driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
        driver.findElement(By.xpath("//td[@data-month='4']//*[text()='30']")).click();

        //Select no. of passengers
        driver.findElement(By.id("divpaxinfo")).click();
        for(int i=0; i<2; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        //Select Currency
        WebElement staticDropdownElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select staticDropdown = new Select(staticDropdownElement);
        staticDropdown.selectByIndex(3);

        //Select Concession Type
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

        //Search Flights
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

        driver.quit();
    }
}
