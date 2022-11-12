package Automation_AI05;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import org.testng.annotations.Test;

public class StateFarm_USBank_BusinessBanking extends Reusable_Annotations {
    @Test(priority = 1)
    public void clickOnBankingBusinessBanking() throws InterruptedException {
        //first navigate to Statefarm homepage
        driver.navigate().to("https://statefarm.com/");

        //next we need to click on banking option
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Banking']",logger,"Banking");

        Thread.sleep(3000);

        //Click on business banking option
        Reusable_Actions_Loggers.clickAction(driver,"//*[@ id ='oneX-1-banking']",logger,"Business Banking");
    }//end of test 1

    @Test(dependsOnMethods = "clickOnBankingBusinessBanking")
    public void checkingPackages() throws InterruptedException {
        //click on "Learn more about U.S. Bank business checking packages"

        Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='-oneX-link--block'] ", 8, "Banking");

        Thread.sleep(3000);
    }//end of test 2
}//end of java class

