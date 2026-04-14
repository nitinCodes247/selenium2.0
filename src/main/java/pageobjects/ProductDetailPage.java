package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver){
        super(driver);
    }

    By productPdpPrice = By.xpath("//span[@class='price']");
    public String getProductPrice(){
        return browserUtils.getText(productPdpPrice);
    }
}
