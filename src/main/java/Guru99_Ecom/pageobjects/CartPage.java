package Guru99_Ecom.pageobjects;

import Guru99_Ecom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {
    WebDriver driver;
    CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "td.product-cart-info")
    List<WebElement> productInfos;

    By productNameLocator = By.cssSelector(".product-name");
    By qtyInput = By.xpath("following-sibling::td[@class='product-cart-actions']/input");
    By qtyUpdate = By.xpath("following-sibling::td[@class='product-cart-actions']/button");
    By qtyErrorMessage = By.cssSelector(".item-msg");

    public void updateQuantity(String productName, String qty){
        for(WebElement e: productInfos){
            if(e.findElement(productNameLocator).getText().equalsIgnoreCase(productName)){
                e.findElement(qtyInput).click();
                e.findElement(qtyInput).clear();
                e.findElement(qtyInput).sendKeys(qty);
                e.findElement(qtyUpdate).click();
                return;
            }
        }
        throw new RuntimeException("Product not added to cart: "+productName);
    }

    public String getQtyErrorMessage(String productName){
        for(WebElement e: productInfos){
            if(e.findElement(productNameLocator).getText().equalsIgnoreCase(productName)){
                return e.findElement(qtyErrorMessage).getText();
            }
        }
        throw new RuntimeException("Product Not available in Cart: "+productName);
    }

}
