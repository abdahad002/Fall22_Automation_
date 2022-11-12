package Day10_103022;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T4_TestNG_ForLoop {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    @Test()
    public void SearchForCar() {
        //add sports to search criteria
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Soccer");
        sports.add("Basketball");
        sports.add("Tennis");

        for (int i = 0; i < sports.size(); i++) {
            driver.navigate().to("https://www.google.com");
            //enter a car on search field
            Reusable_Actions.sendKeysAction(driver, "//*[@name='q']", sports.get(i), "Search Field");
            //hit submit on the google search button
            Reusable_Actions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");
            //capture result text
            String result = Reusable_Actions.getTextAction(driver, "//*[@id='result-stats']", "Search Results");
            //split result for the number
            String[] arrayResult = result.split(" ");
            //print number to the console
            System.out.println("Result is " + arrayResult[1]);
        }//end of for loop
    }//end of test 1
}//end of class
