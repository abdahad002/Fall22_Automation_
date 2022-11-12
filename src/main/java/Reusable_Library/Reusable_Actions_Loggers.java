package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class Reusable_Actions_Loggers {
    static int timeout = 15;

    //reusable method to define and launch webdriver
    public static WebDriver setUpDriver() {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        // options.addArguments("start-maximized");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setup driver method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully able to click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element: " + elementName + " for reason: " + e);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }

    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
        }
    }

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully send keys " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to : " + elementName + " for reason: " + e);
        }
    }

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Successfully able to get text " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text for : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully submit text " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element: " + elementName + " for reason: " + e);
        }
    }//end of submit action

    public static void selectByTextAction(WebDriver driver, String xpath, int index, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            ArrayList<WebElement> element = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(xpath)))));
            Select dropDown = new Select(element.get(index));
            dropDown.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("Unable to selectByVisibleText on element: " + elementName + " for reason: " + e);
        }
    }//end of select by visible text action


    public static void switchToTabsAction(WebDriver driver, int tabByIndex) {
        //Store the tabs in arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to the new tab
        driver.switchTo().window(tabs.get(tabByIndex));
    }//end switch between tabs action

    public static void scrollByViewAction(WebDriver driver, String xpath, ExtentTest logger,int scrollByView,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            ArrayList<WebElement> scrollElement = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollElement.get(scrollByView));
            logger.log(LogStatus.PASS, "successfully scrolled down to view " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll by view " + e);
            logger.log(LogStatus.FAIL, "Unable to scroll down to view " + elementName + " for reason: " + e);
        }
    }//end of scroll by view action

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText
}//end of class