package Guru99_Ecom.pageobjects;

import Guru99_Ecom.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    WebDriver driver;
    String url = "http://live.techpanda.org/";

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href*='mobile.html']")
    WebElement mobilePage;

    public void landOnHomePage(){
        driver.get(url);
    }

    public MobilePage goToMobilePage(){
        mobilePage.click();
        return new MobilePage(driver);
    }
}
