package pageobjects;

import base.BasePage;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    String url = ConfigReader.get("baseUrl");

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a[href*='mobile.html']")
    WebElement mobilePage;

    public void landOnHomePage(){
        driver.get(url);
    }

    public MobilePage goToMobilePage(){
        browserUtils.click(mobilePage);
        return new MobilePage(driver);
    }
}
