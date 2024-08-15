package selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

//    @DataProvider
//    public Object[][] testData(){
//
//        return new Object[][]{
    //This will iterate all these test data
//                {"ular", "id"},
//                {"ulae", "id"},
//                {"ulad", "id"},
//                {"ulat", "id"},
//                {"ulay", "id"},
//                {"ularu", "id"}
//        };
//    }

    @Test(dataProvider = "testData")
    public void testDataProvider(String name, String title){

        System.out.println(name + " " + title);
    }




}
