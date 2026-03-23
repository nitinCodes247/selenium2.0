package Guru99_Ecom.pageobjects;

import Guru99_Ecom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobilePage extends BasePage {
    public MobilePage(WebDriver driver){
        super(driver);
    }
    By sortByMenu = By.xpath("(//select[@title='Sort By'])[1]");


    @FindBy(css = ".product-info")
    List<WebElement> productInfos;

    By productNameLocator = By.cssSelector(".product-name");
    By productPlpPrice = By.cssSelector(".price");
    By atcButtonLocator = By.cssSelector(".actions button");

    public void sotByOption(String option){
        browserUtils.selectByVisibleText(sortByMenu, option);
    }

    public List<String> getAvailableProductNames(){
        return productInfos.stream().map(e -> browserUtils.getText(e.findElement(productNameLocator))).toList();
    }

    public String getProductPrice(String productName){
        for(WebElement e: productInfos){
            if(e.findElement(productNameLocator).getText().equalsIgnoreCase(productName)){
                return browserUtils.getText(e.findElement(productPlpPrice));
            }
        }
        throw new RuntimeException("Product Not Found: " + productName);
    }

    public ProductDetailPage goToProductDetailPage(String productName){
        for(WebElement e: productInfos){
            if(e.findElement(productNameLocator).getText().equalsIgnoreCase(productName)){
                e.findElement(productNameLocator).click();
                return new ProductDetailPage(driver);
            }
        }
        throw new RuntimeException("Product Not Found: " + productName);
    }

    public CartPage addProductToCart(String productName){
        for(WebElement e: productInfos){
            if(e.findElement(productNameLocator).getText().equalsIgnoreCase(productName)){
                e.findElement(atcButtonLocator).click();
                return new CartPage(driver);
            }
        }
        throw new RuntimeException("Product Not Found: " + productName);
    }
}
