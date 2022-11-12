package Day_13_111222;

import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import static Reusable_Library.Reusable_Annotations.driver;
import static Reusable_Library.Reusable_Annotations.logger;

public class T2_StringComparison {
    @Test(priority = 1)
    public void tc001_verifyYahooPageTitle() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //define our expected string variable
        String expectedTitle = "Yahoo..";
        //get page title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            logger.log(LogStatus.PASS, "Expected Result matches Actual Result");
        } else {
            logger.log(LogStatus.FAIL, "Expected Result does not match Actual Result");
        }
    }//end of test 1
    @Test(priority = 1)
    public void tc002_verifyYahooSignInText() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //define our expected string variable
        String actualYahooSignInButtonText = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class = '_yb_18vjf']", logger, "Sign In");
        //define expected string text
        String expectedYahooSignInButtonText = "Sign In";
        Reusable_Actions_Loggers.compareExpectedAndActualText(expectedYahooSignInButtonText, actualYahooSignInButtonText,logger);
    }//end of test 2

}//end of class
