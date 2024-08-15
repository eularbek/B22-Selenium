package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElements {

    WebDriver driver;

    @BeforeMethod
    public void getStarted(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsPractice(){
      //  WebElement element = driver.findElement(By.xpath(""));//returns single element --> throws
        //noSuchElementException if element is missing
        List<WebElement> elements = driver.findElements(By.tagName("li"));//returns multiple elements -->
        //does not throw an exception, instead it will return empty
        int count=0;
        for (int i = 0; i < elements.size(); i++) {
           // String textFromWeb = elements.get(i).getText();
            //System.out.println(textFromWeb);
            //loop through elements, get text length is less than 6, print out and count all these printed string
            if (elements.get(i).getText().length() < 12){
                System.out.println(elements.get(i).getText());
                count++;
            }

        }
        System.out.println("count is " + count);
        int count2 = 0;
      //  for (WebElement element)
        System.out.println("count is " + count);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(4000);
        driver.quit();
    }

}
