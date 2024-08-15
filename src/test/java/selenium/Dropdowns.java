package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dropdowns {

    WebDriver driver;
    @BeforeMethod
    public void getStarted(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownShowCase(){

       driver.get("https://the-internet.herokuapp.com/");

       WebElement dropdownLink = driver.findElement(By.xpath("//a[.='Dropdown']"));
       dropdownLink.click();

       //Now we need to handle the dropdown itself

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdown);
        //select.selectByVisibleText("Option 2");
       // select.selectByValue("2");
        //select.selectByIndex(2);
        List<WebElement> selectOptions = select.getOptions();//? shortcut?
        for (int i = 0; i < selectOptions.size(); i++) {
            if (selectOptions.get(i).getText().equals("Option 2"));
            selectOptions.get(i).click();
        }

//        List<WebElement> allLinks = driver.findElements(By.tagName("//li']"));
//        for (int i = 0; i < allLinks.size(); i++) {
//            System.out.println(allLinks.get(i).getText());
//            System.out.println(allLinks.size());
//
//            if (allLinks.get(i).getText().trim().equalsIgnoreCase("dropdown")){
//                allLinks.get(i).click();
//                break;
//            }
//        }

    }
    @Test
    public void tearDownPractice(){
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");
       /*
       1. Navigate to webpage
       2. Handle the dropdown by choosing Show All Rows
       3. Store lastName and email into Map
       4. Print out the map

        */
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='maxRows']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Show ALL Rows");

        List<WebElement> allLastNames = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String, String> customerInfo = new HashMap<>();
        for (int i = 0; i < allLastNames.size(); i++) {
            customerInfo.put(allLastNames.get(i).getText(), allEmails.get(i).getText());
        }
        System.out.println(customerInfo);

//        Map<String, String> customerInfo = new HashMap<>();
//        for (int i = 0; i < driver.findElements(By.xpath("//tr//td[3]")).size(); i++) {
//
//            String singleLastName = driver.findElements(By.xpath("//tr//td[3]")).get(i).getText();
//            String singleEmail = driver.findElements(By.xpath("//tr//td[4]")).get(i).getText();
//            customerInfo.put(singleLastName, singleEmail);
//        }
//        System.out.println(customerInfo);

    }

    @Test
    public void practice() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        /*
        1. Navigate to Lambda webpage
        2. Fill out the input forms
        3. For the country dropdown choose your country with Select getOptions method by looping each option
         if option has your country click on it
        4. Submit the form
        5. Validate the success message at the end
         */
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Bek Erg");

        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        email.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("123456789");

        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("IMB");

        WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("www.ibm.com");

        Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase("united kingdom")){
                select.getOptions().get(i).click();
            }
        }

        Thread.sleep(3000);
        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Chicago");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("1234 test str");


        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("4321 Test avenue");

        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("IL");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCode.sendKeys("60656");

        WebElement submitButton = driver.findElement(By.xpath("//button[.='Submit']"));
        submitButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));

        String actualMessage = successMessage.getText();
        String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";

        Assert.assertEquals(actualMessage, expectedMessage, "Failed to validate success message on the submit page");

    }

      @Test
      public void bookFlight() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        //clicking One Way Radio button
        WebElement radioButtonOneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        radioButtonOneWay.click();

        //select passenger number
          WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
          Select passengerDropdown = new Select(passenger);
          passengerDropdown.selectByIndex(3);

          //select departing city
          WebElement departingCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
          Select departCityDropdown = new Select(departingCity);
          departCityDropdown.selectByVisibleText("Zurich");

          //select departing on month
          WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
          Select fromMonthDropdown = new Select(fromMonth);
          fromMonthDropdown.selectByValue("9");

          //select departing day
          WebElement departingDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
          Select departingDayDropdown = new Select(departingDay);
          departingDayDropdown.selectByVisibleText("21");

          //select arriving city
          WebElement arriveCity = driver.findElement(By.xpath("//select[@name='toPort']"));
          Select arriveCityDropdown = new Select(arriveCity);
          arriveCityDropdown.selectByVisibleText("Sydney");

          //select returning month
          WebElement returnMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
          Select returnMonthDropdown = new Select(returnMonth);
          returnMonthDropdown.selectByIndex(11);

          //select returning day
          WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']"));
          Select returnDayDropdown = new Select(returnDay);
          returnDayDropdown.selectByValue("25");

          //click in First Class radio button
          WebElement firstClassRadioButton = driver.findElement(By.xpath("//input[@value='First']"));
          firstClassRadioButton.click();

          //loop through select options and select unified airlines with getOptions method from select class
          WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
          Select airlinesDropdown = new Select(airlines);

          //getting all options from the dropdown, and looping through them. Also, declaring if condition to
          //-check if my desired option is available, if true it clicks on it
          List<WebElement> options = airlinesDropdown.getOptions();
          for (WebElement eachAirline : options){
              if (eachAirline.getText().equalsIgnoreCase("Unified Airlines")){
                  eachAirline.click();
                  break;
              }
          }
          Thread.sleep(3000);


          //click on continue button
          WebElement continueBtn = driver.findElement(By.name("findFlights"));
          continueBtn.click();

          //Validate the message on submitted page
          WebElement message = driver.findElement(By.xpath("//b//font[@size='4']"));

          String actualMessage = message.getText().trim();

          String expectedMessage = "After flight finder - No Seats Avaialble";


          Assert.assertEquals(actualMessage, expectedMessage, "Failed to validate message on submitted page");


          // WebElement method
          WebElement element = driver.findElement(By.name(""));
          element.getText();
          element.click();
          element.sendKeys("");
          element.isDisplayed();
          element.clear();



          //driver methods
          driver.get("");
          driver.getCurrentUrl();
          driver.getTitle();
          driver.getPageSource();


          //Select methods
          Select select = new Select(element);
          select.selectByValue("");
          select.selectByIndex(4);
          select.selectByVisibleText("");
          select.getOptions();
      }


    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(4000);
        driver.quit();
    }

}
