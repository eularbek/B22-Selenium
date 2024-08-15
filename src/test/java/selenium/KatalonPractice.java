package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonPractice {
    WebDriver driver;

    @BeforeMethod //this method will be executed before each @Test annotation. If you have 10
    //
    public void initializeDriver(){
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void checkBookFunctionality() throws InterruptedException {
        //clicking on make appointment button
        WebElement makeAppButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppButton.click();
        //enter username into username input field
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys("John Doe");

        //enter password into password input field
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("ThisIsNotAPassword");

        Thread.sleep(4000);
        //click on login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        //check checker for 'Apply for hospital readmission'
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (!checkBox.isSelected()){
            checkBox.click();
        }
        //sendKeys into a date from datePicker
        WebElement datePicker = driver.findElement(By.xpath("//input[@name='visit_date']"));
        datePicker.sendKeys("31/07/2024");

        //sendKeys into comment box
        WebElement commentBox = driver.findElement(By.xpath("//textarea[@name='comment']"));
        commentBox.sendKeys("Please book me a 5 star hotel as well in Tokyo");

        //click on book appointment button
        WebElement bookAppButton = driver.findElement(By.xpath("//button[@type='submit']"));
        bookAppButton.click();

        Thread.sleep(4000);
        //validate the facility text
        WebElement facilityText = driver.findElement(By.xpath("//p[@id='facility']"));
        if (facilityText.isDisplayed()){
            System.out.println(facilityText.getText()+ " Facility text is present");
        }
        //validate readmission text
        WebElement readmissionText = driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
        if (readmissionText.isDisplayed()){
            System.out.println("Rea" + readmissionText.getText());
        }
        //validate medical program
        WebElement medicare = driver.findElement(By.id("program"));
        if (medicare.isDisplayed()){
            System.out.println("Medicare text is present " + medicare.getText());
        }
        //validate visit date
        WebElement visitDate = driver.findElement(By.xpath("//p[@id='visit_date']"));
        if (visitDate.isDisplayed()){
            System.out.println("Visit date is " + visitDate.getText());
        }
        //validate comment left by the customer
        WebElement commentText = driver.findElement(By.id("comment"));
        if (commentText.isDisplayed()){
            System.out.println(" Comment is visible " + commentText.getText());
        }
        //click on go home page
        WebElement goHomeButton = driver.findElement(By.xpath("//a[contains(text(),'Go')]"));
        goHomeButton.click();
        

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(4000);
        driver.quit();
    }


}
