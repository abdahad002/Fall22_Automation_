package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class T3_ExplicitWait_Metlife {
    public static void main(String[] args) throws InterruptedException {


        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

// add the options for maximizing the chrome meeting
// options.addArguments("start-fullscreen") for mac
        options.addArguments("kiosk");
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //navigate to metlife home page
        driver.navigate().to("https://www.metLife.com");

        //Declare the explicit wait.. Only for explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //click on solutions tab using explicit condition
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'SOLUTIONS')]"))).click();

        //click on first dental link
        ArrayList<WebElement> dentalLink = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='Dental']"))));
        dentalLink.get(0).click();

    }//end of main
}//end of java class
