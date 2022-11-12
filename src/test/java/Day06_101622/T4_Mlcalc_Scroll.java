package Day06_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_Mlcalc_Scroll {

    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        options.addArguments("--kiosk", "incognito");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //go to mortgage calc site
        driver.navigate().to("https://www.mlcalc.com");
        //wait 3 secs
        Thread.sleep(1000);

        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down to 800 pixels
        jse.executeScript("scroll(0,2000)");
        //wait 2 secs
        Thread.sleep(2000);
        //scroll up to 400 pixels
        jse.executeScript("scroll(0,-1)");
        //wait 2 secs
        Thread.sleep(2000);
        //store calculate button into webelement variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));
        //scroll into view of calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        //wait 2 secs
        Thread.sleep(2000);
        //quit chrome
        driver.quit();


    }//end of main
}//end of class
