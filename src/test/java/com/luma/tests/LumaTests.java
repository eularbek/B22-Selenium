package com.luma.tests;

import com.luma.pages.CheckoutPage;
import com.luma.pages.LumaMainPage;
import com.luma.pages.ProductListPage;
import org.testng.annotations.Test;
import utils.TestBase;

public class LumaTests extends TestBase {

    @Test
    public void validatePurchaseExperience() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");

        LumaMainPage mainPage = new LumaMainPage(driver);
        mainPage.clickOnBags(driver);

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.chooseProductAndCheckOut(driver);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.customerInfo(driver, "test@gmail.com", "John", "Snow", "Lake ave",
                "Chicago", "Kansas", "60018", "United States", "77334455");
    }

    @Test
    public void testGoogleWithXml(){
        driver.get("https://www.google.com/");
        System.out.println("We navigated to google home page");
    }


}
