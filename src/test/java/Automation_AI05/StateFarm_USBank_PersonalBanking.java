package Automation_AI05;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import org.testng.annotations.Test;

public class StateFarm_USBank_PersonalBanking extends Reusable_Annotations {
    @Test(priority = 1)
    public void clickOnBankingPersonalBanking() throws InterruptedException {
        //first navigate to Statefarm homepage
        driver.navigate().to("https://statefarm.com/");

        //next we need to click on banking option
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Banking']",logger,"Banking");

        Thread.sleep(3000);

       //Click on personal banking option
        Reusable_Actions_Loggers.clickAction(driver,"//*[@ id ='oneX-0-banking']",logger," Personal Banking");
    }//end of test 1

    @Test(dependsOnMethods = "clickOnBankingPersonalBanking")
    public void scrollDowntoViewOptionsandSelect () throws InterruptedException {

        //Scroll down to view different personal banking services
        Reusable_Actions_Loggers.scrollByViewAction(driver,"//*[@ id ='savings']",logger,0, "Scroll down");

        Thread.sleep(3000);

        //click on "See U.S. Bank savings accounts"

        Reusable_Actions_Loggers.clickActionByIndex(driver,"//*[@class='-oneX-link--block'] ",12,"Banking");

        Thread.sleep(3000);

    }//end of test 2
}//end of java class
