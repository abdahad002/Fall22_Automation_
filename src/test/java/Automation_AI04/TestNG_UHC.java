package Automation_AI04;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_UHC {

    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method


    @Test()
    public void Dentist () throws InterruptedException {

        //navigating to uhc homepage
        driver.navigate().to("https://www.uhc.com/");
        //wait few seconds
        Thread.sleep(2000);
        //clicking on find a doctor
        Reusable_Actions.clickAction(driver, "//*[@aria-label='Find a doctor']", "find doctor");
        //wait few seconds
        Thread.sleep(3000);
        //clicking to the side for the popUp to vanish
        //handle pop up window
        try {
            WebElement weValueYourFeedback = driver.findElement(By.xpath("//*[@id='layer-container-127097']"));
            if (weValueYourFeedback.isDisplayed()) {
                driver.findElement(By.xpath("//*[@id='ip-no']")).click();
            }//end of if condition
        }catch (Exception e){
            System.out.println("Unable to find pop up window " + e);
        }//end of pop up window exception

        //scroll down to Find a dentist

        Reusable_Actions.scrollByView(driver, "//*[text()='Find a dentist']", "scroll to Dentist");
        //wait few seconds
        Thread.sleep(7000);
        //click on find a dentist
        Reusable_Actions.clickAction(driver, "//*[text()='Find a dentist']", "click on find a dentist");
        // switching to new tab
        Reusable_Actions.switchToTabByIndex(driver, 1);

        //clicking on employer and individual plan
        Reusable_Actions.clickActionByIndex(driver, "//*[@class='img']", 0, "click on employer");
    }//end of Test 1



    @Test(dependsOnMethods = "Dentist")
    public void zipSearch () throws InterruptedException {
        //wait few seconds
        Thread.sleep(1000);
        //sending zipCode values to search box
        Reusable_Actions.sendKeysAction(driver, "//*[@id='location']", "11561", "sending zipcodes");
        //wait few seconds
        Thread.sleep(1000);
        //selecting from the dropDown
        Reusable_Actions.clickActionByIndex(driver,"//*[@id='auto_0']",0,"dropDown");
        //wait few seconds
        Thread.sleep(1000);
        //clicking on continue
        Reusable_Actions.clickAction(driver, "//*[@type='submit']", "click enter button");

        //clicking on National Options
        Reusable_Actions.clickActionByIndex(driver,"//*[@class='sc-jomqko TEkcT']",0,"NationalOptions");
        //wait few seconds
        Thread.sleep(3000);
        //refresh the page
        driver.navigate().refresh();
        //wait few seconds
        Thread.sleep(3000);

        Reusable_Actions.clickActionByIndex(driver,"//*[@class='sc-jgPyTC gXqeMb']",0,"Click on general dentist");

        //wait few seconds
        Thread.sleep(3000);
    }// end of test 2
    @Test(dependsOnMethods = "zipSearch")
    public void doctorInfo () throws InterruptedException {
//wait few seconds
        //Thread.sleep(3000);
        Reusable_Actions.selectByText(driver,"//*[contains(@class,'radiusMiles ng-pristine')]","'Within 20 Miles","miles dropdown");
        //refresh the page
        driver.navigate().refresh();
        //wait few seconds
        Thread.sleep(3000);
        //click on miles dropDown

        //clicking on the doctor name
        Reusable_Actions.clickActionByIndex(driver,"//*[@data-test-id='provider-name-link']",0,"doctor name");
        //wait few second
        Thread.sleep(3000);
        //click on save button
        Reusable_Actions.clickAction(driver,"//*[contains(@class,'cta-header-button action-btn saved')]","save icon");
        //capturing address, miles and distance
        //capturing address
        String Address = Reusable_Actions.getTextAction(driver,"//*[@class='btn-label-wrapper']","address");
        //capturing miles
        String Miles =  Reusable_Actions.getTextAction(driver,"//*[@class='block mapLink']","miles");
        //wait few second
        Thread.sleep(2000);
        //capturing network
        String Network = Reusable_Actions.getTextAction(driver,"//*[@value='::location.inNetwork']","network");
        //wait few second
        Thread.sleep(2000);
        //printing out address,miles and distance
        System.out.println("Address Value = " + Address + " Miles value = " +  Miles + "Network Value = " + Network);
        // closing the second tab
        driver.close();
    }//end of test 3
    @Test(dependsOnMethods = "doctorInfo")
    public void result() throws InterruptedException {
// switching back to default tab
        Reusable_Actions.switchToTabByIndex(driver,0);
        //wait few second
        Thread.sleep(2000);
        //searing "doctor" on search box
        Reusable_Actions.sendKeysAction(driver,"//*[@id='search-desktop']", "doctor","search doctor");
        //clicking on search icon
        //wait few second
        Thread.sleep(2000);
        //click on search icon
        Reusable_Actions.submitAction(driver,"//*[@id ='search__button-desktop']","search icon");
        // capturing  split search numbers

        String searchNumber =  Reusable_Actions.getTextAction(driver,"//*[@id='search-results-count__header']","searchSplit");
        String [] split =searchNumber.split(" ");
        System.out.println("my search result value: " + split[0] + split[1] + split[2]);
    }//end of test 4
    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

}//end of class


