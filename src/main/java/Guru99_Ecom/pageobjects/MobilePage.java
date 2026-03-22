package Guru99_Ecom.pageobjects;

import Guru99_Ecom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MobilePage extends BasePage {
    WebDriver driver;
    MobilePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".page-title h1")
    WebElement pageTitle;

    @FindBy(xpath = "(//select[@title='Sort By'])[1]")
    WebElement sortByMenu;

    @FindBy(css = ".product-info")
    List<WebElement> productInfos;

    By productNameLocator = By.cssSelector(".product-name");
    By productPlpPrice = By.cssSelector(".price");
    By atcButtonLocator = By.cssSelector(".actions button");

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void sotByOption(String option){
        Select options = new Select(sortByMenu);
        options.selectByVisibleText(option);
    }

    public List<String> getAvailableProductNames(){
        return productInfos.stream().map(e -> e.findElement(productNameLocator).getText()).toList();
    }

    public String getProductPrice(String productName){
        for(WebElement e: productInfos){
            if(e.findElement(productNameLocator).getText().equalsIgnoreCase(productName)){
                return e.findElement(productPlpPrice).getText();
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
