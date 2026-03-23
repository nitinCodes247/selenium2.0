package Guru99_Ecom.pageobjects;

import Guru99_Ecom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "td.product-cart-info")
    List<WebElement> productInfos;
    @FindBy(css = ".cart-footer-actions")
    WebElement cartFooterSection;

    By productNameLocator = By.cssSelector(".product-name");
    By qtyInput = By.xpath(".//following-sibling::td[@class='product-cart-actions']/input");
    By qtyUpdate = By.xpath(".//following-sibling::td[@class='product-cart-actions']/button");
    By qtyErrorMessage = By.cssSelector(".item-msg");
    By emptyCart = By.id("empty_cart_button");

    public void updateQuantity(String productName, String qty){
        for(WebElement e: productInfos){
            if(e.findElement(productNameLocator).getText().equalsIgnoreCase(productName)){
                WebElement inputQtyBox = e.findElement(qtyInput);
                browserUtils.click(inputQtyBox);
                browserUtils.type(inputQtyBox, qty);
                browserUtils.click(e.findElement(qtyUpdate));
                return;
            }
        }
        throw new RuntimeException("Product not added to cart: "+productName);
    }

    public String getQtyErrorMessage(String productName){
        for(WebElement e: productInfos){
            if(e.findElement(productNameLocator).getText().equalsIgnoreCase(productName)){
                return browserUtils.getText(e.findElement(qtyErrorMessage));
            }
        }
        throw new RuntimeException("Product Not available in Cart: "+productName);
    }

    public String emptyCart(){
        browserUtils.click(cartFooterSection.findElement(emptyCart));
        return getPageTitle();
    }

}
