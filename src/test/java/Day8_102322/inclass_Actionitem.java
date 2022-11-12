package Day8_102322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

import static org.openqa.selenium.By.*;

public class inclass_Actionitem {
    public static void main(String[] args) throws InterruptedException {


        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        // add the options for maximizing the chrome meeting
        options.addArguments("kiosk");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);


        //declare and define an arraylist of destination
        ArrayList<String> destination  = new ArrayList<>();
        //now add the values for destination array
        destination.add("Orlando");
        destination.add("Los Angeles");
        destination.add("New York");

        //using forLoop to iterate through the test steps multiple times
        for (int i = 0; i < destination.size(); i++) {
            //navigate to hotels.com

            try {
                driver.navigate().to("https://www.hotels.com/");
            }catch (Exception e){
                System.out.println("unable to go to hotels.com"+e);
            }

            Thread.sleep(2000);


            //using find element click on type your destination/ going to section on the search field
            driver.findElement(By.xpath("//*[@class='uitk-typeahead']")).click();

            //create a webElement variable to enter new element on the searchBar
            ArrayList<WebElement> searchBar = new ArrayList<>(driver.findElements(By.xpath("//*[@id='destination_form_field']")));


            //pass the destination
            searchBar.get(0).sendKeys(destination.get(i));

            //click on the first option for destination
            driver.findElement(By.xpath("//*[@class ='is-subText truncate']")).click();


            //click on travelers section
            driver.findElement(By.xpath("//*[contains(@class,'uitk-fake-input')]")).click();


            //hit submit on the site search button
      //      driver.findElement(By.xpath("//*[contains(@class,'uitk-icon')")).click();










        }
    }//end of main
}//end of java class
