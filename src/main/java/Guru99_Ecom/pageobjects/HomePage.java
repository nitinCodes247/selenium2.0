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

    @FindBy(xpath = "//div[@class='page-title']/h2")
    WebElement pageTile;

    public void landOnHomePage(){
        driver.get(url);
    }

    public MobilePage goToMobilePage(){
        mobilePage.click();
        return new MobilePage(driver);
    }

    public String getPageTitle(){
        return pageTile.getText();
    }
}
