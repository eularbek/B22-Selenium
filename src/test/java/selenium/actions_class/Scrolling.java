package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.TestBase;

public class Scrolling extends TestBase {

    @Test
    public void scrollToElementPractice() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");

        WebElement flashingImage = driver.findElement(By.xpath("//h2[.='Flashing']//following-sibling::div//img"));

        Actions actions = new Actions(driver);

        //scrolling to the element
        actions.scrollToElement(flashingImage).build().perform();

       // actions.scrollByAmount(0, 3000).build().perform();
       // Thread.sleep(4000);
        //Hover over
       // actions.moveToElement(flashingImage).build().perform();

    }
}
