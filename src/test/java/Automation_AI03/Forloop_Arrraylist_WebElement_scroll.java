package Automation_AI03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Forloop_Arrraylist_WebElement_scroll {

        public static void main(String[] args) throws InterruptedException {

            //setup your chromedriver with webdrivermanager
            WebDriverManager.chromedriver().setup();

            //initialize chrome options
            ChromeOptions options = new ChromeOptions();

            //add options to set chrome driver with incognito
            options.addArguments("incognito");

            //add options for maximizing the chrome window
            options.addArguments("--kiosk");


            //define the webdriver and pass the options into the method
            WebDriver driver = new ChromeDriver(options);

            //declare and define an arraylist of zipCodes
            ArrayList<String> zipCodes = new ArrayList<>();
            //now add the values for zipCodes array
            zipCodes.add("11561");
            zipCodes.add("11779");
            zipCodes.add("11933");

            //using forLoop to iterate through the test steps multiple times
            for (int i = 0; i < zipCodes.size(); i++) {

                //navigate to the weight watchers site
                driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");


                //using find element click on find a workshop link
                driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();

                //using find element click on In person link
                driver.findElement(By.xpath("//*[text()='In-Person']")).click();

                //wait few seconds
                Thread.sleep(3000);

                //create a webElement variable to enter new element on the searchBar
                WebElement searchBar = driver.findElement(By.xpath( "//[id='location-search']"));

                //clear the searchBar
                searchBar.clear();

                //pass the zipCodes
                searchBar.sendKeys(zipCodes.get(i));

                //click on search arrow
                driver.findElement(By.xpath("//*[contains(@class,'rightArrow')]")).click();

                //wait few seconds
                Thread.sleep(2000);

                //using findElements to locate and click on a specific studio
                ArrayList<WebElement> studioLink = new ArrayList<>(driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")));

                //using if condition statement click on different studio links
                if (i==0) {
                    studioLink.get(1).click();
                }
                else if (i==1) {
                    studioLink.get(2).click();
                }
                else if (i==2) {
                    studioLink.get(0).click();
                }//end of conditional statement

                //wait few seconds
                Thread.sleep(2000);

                //capture the entire address on a variable and print out the address
                String address = driver.findElement(By.xpath("//*[@class='infoContainer-12kv1']")).getText();

                //split the address lines by the "return"/next line to capture just the address lines
                String[] addressSplit = address.split("\\R");

                //print the appropriate statement
                System.out.println("For zip code " + zipCodes.get(i) + " the location is " + studioLink + " the address is " + addressSplit[0] + " " + addressSplit[1]);

                //define javascript executor
                JavascriptExecutor jse = (JavascriptExecutor) driver;

                //scroll to studio workshop schedule
                WebElement scrollView = driver.findElement(By.xpath("//*[contains(@class,'workshopSchedule')]"));

                //scroll to studio workshop schedule
                jse.executeScript("arguments[0].scrollIntoView(true);",scrollView);

                //capture the entire table with days and hours for studio workshop schedule and print it on a separate print statement
                String table = driver.findElement(By.xpath("//*[@class='workshopSchedule-2foP8']")).getText();

                //printing the table
                System.out.println(table);
                //create an empty space between each location for a proper view
                System.out.println();

            }//end of for loop
        }//end of main
}//end of java class

