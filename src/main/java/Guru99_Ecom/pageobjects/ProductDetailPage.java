package Guru99_Ecom.pageobjects;

import Guru99_Ecom.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {
    WebDriver driver;
    ProductDetailPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='price']")
    WebElement productPdpPrice;

    public String getProductPrice(){
        return productPdpPrice.getText();
    }
}
