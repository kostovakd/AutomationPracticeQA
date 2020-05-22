package com.accenture.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DressDetailPage;
import pages.DressesPage;
import pages.HomePage;

public class DressesWebTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "Kristina")
    public void buySummerDresses() {

        // Open www.automationpractice.com site.
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Hover on the top menu and then click on Summer Dresses.
        DressesPage dressesPage = homePage.hoverClickSummerDresses(getDriver());
        Assert.assertTrue(dressesPage.hasSummerDressesText(getDriver()));

        // Choose the middle dress and click 'Quick view'.
        DressDetailPage dressDetailPage = dressesPage.clickQuickView();
        Assert.assertTrue(dressDetailPage.hasTweetButton(getDriver()));
        Assert.assertTrue(dressDetailPage.hasFacebookButton(getDriver()));

        // Set quantity, size and color of the dress. Add to cart.
        dressDetailPage.clickQuantity(2);
        dressDetailPage.selectSize();
        dressDetailPage.changeColor();
        dressDetailPage.clickAddToCart();
        Assert.assertTrue(dressesPage.hasIconProceedToCheckoutButton(getDriver()));

        // Close the confirmation window.
        DressesPage newDressesPage = dressDetailPage.closeWindow();

        // Hover on cart and confirm that product details are correct.
        newDressesPage.hoverBasket(getDriver());
        Assert.assertTrue(dressesPage.hasCorrectCartProductName(getDriver(), "Printed Summer Dress"));
        Assert.assertEquals(dressesPage.getCartProductQuantity(getDriver()), "3");
        Assert.assertEquals(dressesPage.getCartProductSizeAndColor(getDriver()), "White, M");
        Assert.assertEquals(dressesPage.getCartProductPrice(getDriver()), "$91.50");
        Assert.assertEquals(dressesPage.getCartTotalPrice(getDriver()), "$93.50");
    }
}