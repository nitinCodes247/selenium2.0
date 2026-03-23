package Guru99_Ecom.tests;

import Guru99_Ecom.pageobjects.MobilePage;
import Guru99_Ecom.pageobjects.ProductDetailPage;
import Guru99_Ecom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MobileListPageTests extends BaseTest {

    @Test(description = "Verify item in Mobile List page can be sorted by 'Name'")
    public void verifyNameSortingMobilePage() {

        String sortByName = "Name";

        String pageTitle = homePage.getPageTitle();
        Assert.assertTrue(pageTitle.contains("THIS IS DEMO SITE"));

        MobilePage mobilePage = homePage.goToMobilePage();
        pageTitle = mobilePage.getPageTitle();
        Assert.assertEquals(pageTitle,"MOBILE");

        mobilePage.sotByOption(sortByName);

        List<String> productNames = mobilePage.getAvailableProductNames();
        List<String> sortedProductNames = productNames.stream().sorted().toList();

        Assert.assertEquals(sortedProductNames, productNames);
    }

    @Test(description = "Verify the product costs between Mobile Listing Page & Product Detail Page")
    public void verifyProductCost(){
        String productName = "IPhone";
        MobilePage mobilePage = homePage.goToMobilePage();

        String xperiaPricePLP = mobilePage.getProductPrice(productName);
        ProductDetailPage productDetailPage = mobilePage.goToProductDetailPage(productName);

        String xperiaPricePDP = productDetailPage.getProductPrice();

        Assert.assertEquals(xperiaPricePLP,xperiaPricePDP);

    }


}
