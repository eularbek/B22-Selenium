package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestBase;

public class DataProviderLocation extends TestBase {

//        @DataProvider
//    public Object[][] testData(){
//
//        return new Object[][]{
//                {"ular", "id"},
//                {"ulae", "id"},
//                {"ulad", "id"},
//                {"ulat", "id"},
//                {"ulay", "id"},
//                {"ularu", "id"}
//        };
//    }
     //Data is located in DataProviderLocation class
    @Test(dataProvider = "testData", dataProviderClass = DataProviderLocation.class)
    public void testDataProvider(String name, String title){

        System.out.println(name + " " + title);
    }

    @DataProvider
    public Object[][] testData(){

        return new Object[][]{
                {"test@test", "123456789", "Warning: No match for E-Mail Address and/or Password."},
                {"test@tegt", "gssjfsfhh", "Warning: No match for E-Mail Address and/or Password."},
                {"gibrish@test", "12788999hh", "Warning: No match for E-Mail Address and/or Password."}
        };
    }

    @Test(dataProvider = "testData")
    public void realTestDataProvider(String email, String passcode, String expectedErrorMsg){

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

        WebElement username = driver.findElement(By.cssSelector("#input-email"));
        username.sendKeys(email);

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys(passcode);

        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        submitBtn.click();

        WebElement warningMessage = driver.findElement(By.xpath("//div[contains(text(),'Warning')]"));

        String actualMessage = warningMessage.getText();
        Assert.assertEquals(actualMessage, expectedErrorMsg, "Failed to validate error message");


    }




}






































