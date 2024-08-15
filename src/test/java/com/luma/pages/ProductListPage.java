package com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ProductListPage {

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//img[@alt='Push It Messenger Bag']")
    WebElement bagImage;


    @FindBy(xpath = "//img[@alt='Push It Messenger Bag']//..//..//..//following-sibling::div//button")
    WebElement oneSpecificBag;

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cartButtonFromPrList;

    @FindBy(css = "#top-cart-btn-checkout")
    WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//a[contains(.,'Sign In')]")
    WebElement signInButton;

    @FindBy(xpath = "//span[@class='counter qty']//span[.='1']")
    WebElement quantityInCart;

    public void chooseProductAndCheckOut(WebDriver driver) throws InterruptedException {

        //This will choose one specific bag, hovers over it, and clicks on add to cart button
        Actions actions = new Actions(driver);
        actions.moveToElement(this.bagImage).click(this.oneSpecificBag).build().perform();

        // Clicks on cart btn , then proceed to checkout btn

        BrowserUtils.click(this.quantityInCart, driver);
        BrowserUtils.scrollWithJs(driver, this.quantityInCart);
        BrowserUtils.click(this.proceedToCheckOutBtn, driver);
    }

}
