package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

   public WebDriver driver;

    @BeforeMethod
    public void initializeDriver(){

        driver = DriverHelper.getDriver();

//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        System.out.println("Driver is initialized");
    }

    @AfterMethod
    public void tearDown() throws  InterruptedException{
        Thread.sleep(4000);
        driver.quit();
        System.out.println("Driver is shut down");
    }
}
