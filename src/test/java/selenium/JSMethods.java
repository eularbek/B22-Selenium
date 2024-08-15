package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

public class JSMethods extends TestBase{



    //Implementing some JavaScript methods
    @Test
    public void getTitleWithJS(){

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.open('https://www.abt.com/')");
        driver.get("https://www.abt.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualTitle = js.executeScript("return document.title").toString();
        String expectedTitle = "Abt: Appliances and Electronics Store | Refrigerators, Appliances, TVs";
        Assert.assertEquals(actualTitle, expectedTitle, "Failed to validate title of abt.com");
        System.out.println(actualTitle);

    }

    @Test
    public void clickWithJS(){

    driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()", aboutUs);

    }

    @Test
    public void scrollWithJs(){

        driver.get("https://codefish.io/");
        WebElement faceBookLogo = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", faceBookLogo);

    }

    @Test
    public void getURLWithJS(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://codefish.io/')");
        js.executeScript("window.open('https://www.google.com/')");
        js.executeScript("window.open('https://www.costco.com/')");

        String expectedTitle = "Google";

        BrowserUtils.switchWindowWithTitle(driver, expectedTitle);
        System.out.println(driver.getTitle());


    }

    @Test
    public void switchURL(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.google.com/')");
        js.executeScript("window.open('https://www.costco.com/')");
        js.executeScript("window.open('https://www.abt.com/')");
        js.executeScript("window.open('https://www.bestbuy.com/')");

        String title = "Google";

        BrowserUtils.switchWindowWithTitle(driver, title);

        WebElement input = driver.findElement(By.cssSelector("#APjFqb"));
        input.sendKeys("iPhone");




    }

    @Test
    public void check(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.google.com/')");
        js.executeScript("window.open('https://www.costco.com/')");
        js.executeScript("window.open('https://www.abt.com/')");
        js.executeScript("window.open('https://www.bestbuy.com/')");

        String title = "Costco";

        BrowserUtils.switchWindowWithTitle(driver, title);

        WebElement input = driver.findElement(By.cssSelector("//input[@id=':r9:']"));
        input.sendKeys("iPhone");

    }

    @Test
    public void scrollWithPointClass(){

        driver.get("https://the-internet.herokuapp.com/");

        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Point point = elementalSelenium.getLocation(); //it will get the location in a numerical form and stored it in point
//        int x = point.getX(); //gets the horizontal distance from the edge of the screen to webElement
//        int y = point.getY();// gets the vertical distance from the edge of the screen to webElement
//
//        js.executeScript("window.scrollTo("+ x +","+ y +")");
        BrowserUtils.scrollWithPoint(elementalSelenium, driver);

    }

}
