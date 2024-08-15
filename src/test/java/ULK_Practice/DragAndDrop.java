package ULK_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.TestBase;

public class DragAndDrop extends TestBase {

    @Test
    public void dragAndDropPractice(){

        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));

        WebElement dropZone = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, dropZone).build().perform();

        driver.close();


    }
}
