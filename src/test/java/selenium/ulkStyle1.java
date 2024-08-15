package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ulkStyle1 {
    @Test
    public void ulkShowCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(4000);
        WebElement nameField = driver.findElement(By.cssSelector("#seleniumbox"));
        nameField.click();

        WebElement javaClick = driver.findElement(By.cssSelector("#java1"));
        javaClick.click();

        Thread.sleep(2000);
        WebElement php1Btn = driver.findElement(By.cssSelector("#php1"));
        php1Btn.click();

        WebElement yellowBtn = driver.findElement(By.cssSelector("option[value='yellow']"));
        BrowserUtils.selectBy(yellowBtn, "Yellow Shirt", "visibleText");

        WebElement saveBtn = driver.findElement(By.cssSelector("#demo"));
        saveBtn.click();

        driver.close();
    }
}
