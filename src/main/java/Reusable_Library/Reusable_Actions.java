package Reusable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions {
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

    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }

    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
        }
    }

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
        }
    }

    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }

    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
        }
    }//end of submit action

    public static void selectByText(WebDriver driver, String xpath, String userData, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userData);

        }catch(Exception e) {
            System.out.println("Unable to select visible text for : " + elementName + " for reason: " + e);
        }//end of catch

    }//End of select by visible text
    public static void switchToTabByIndex (WebDriver driver, int index) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            //store the tabs in arraylist
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to the new tab
            driver.switchTo().window(tabs.get(index));


        } catch (Exception e) {
            System.out.println("Unable to switch tab by index: " + " for reason: " + e);
        }
    }//


    public static void scrollByView(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            //define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll down to 800 pixels
            jse.executeScript("argument[0].scrollByView(true);", element);

        } catch (Exception e) {
            System.out.println("Unable to scroll by view: " + elementName + " for reason: " + e);
        }
    }//

}
