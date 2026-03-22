package Guru99_Ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyProductCost extends BaseTest{
    @Test
    public void verifyProductCost(){
        // Go to mobile page and get all the product infos
        driver.findElement(By.cssSelector("a[href*='mobile.html']")).click();
        List<WebElement> productInfos = driver.findElements(By.cssSelector(".product-info"));

        // Extract the price of the Sony Xperia on PLP page
//        String xperiaPricePLP = productInfos.stream()
//                .filter(e -> e.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase("Sony Xperia"))
//                .map(e -> e.findElement(By.xpath("//span[@class='price']")).getText()).toString();

        String xperiaPricePLP = "";
        for(WebElement e: productInfos) {
            WebElement productElement = e.findElement(By.cssSelector(".product-name a"));
            if (productElement.getText().equalsIgnoreCase("Sony Xperia")) {
                // Extract the price of the Sony Xperia on PLP page
                xperiaPricePLP = e.findElement(By.xpath(".//span[@class='price']")).getText();
                // Go to the PDP page
                productElement.click();
                break;
            }
        }

        String xperiaPricePDP = driver.findElement(By.xpath("//span[@class='price']")).getText();

        Assert.assertEquals(xperiaPricePLP,xperiaPricePDP);

    }
}
