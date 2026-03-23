package Guru99_Ecom.base;

import Guru99_Ecom.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected final WebDriver driver;
    protected BrowserUtils browserUtils;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.browserUtils = new BrowserUtils(driver);
    }

    @FindBy(css = ".page-title")
    WebElement pageTitle;


    public String getPageTitle(){
        return pageTitle.getText();
    }
}
