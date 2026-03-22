package Guru99_Ecom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    protected Actions a;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.a = new Actions(driver);
    }

    @FindBy(css = ".page-title")
    WebElement pageTitle;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public String getPageTitle(){
        return pageTitle.getText();
    }
}
