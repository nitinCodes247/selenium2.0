package Guru99_Ecom;

import Guru99_Ecom.pageobjects.CartPage;
import Guru99_Ecom.pageobjects.MobilePage;
import Guru99_Ecom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTests extends BaseTest {

    @Test
    public void maxAllowedQuantity() {
        String addQty = "1000";
        String productName = "Sony Xperia";

        MobilePage mobilePage = homePage.goToMobilePage();
        CartPage cartPage = mobilePage.addProductToCart(productName);

        cartPage.updateQuantity(productName, addQty);
        String qtyErrorMessage = cartPage.getQtyErrorMessage(productName);
        String expectedErrorMessage = "* The maximum quantity allowed for purchase is 500.";
        Assert.assertEquals(qtyErrorMessage,expectedErrorMessage);

        String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";
        Assert.assertEquals(cartPage.emptyCart(), expectedEmptyCartMessage);
    }
}
