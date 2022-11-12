package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XpathTextContains {

    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();


        //define the chrome driver to
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");

        //maximize my window

        driver.manage().window().fullscreen();

        //click on sign in button
        driver.findElement(By.xpath( "//*[text() = 'Sign in']")).click();

        //sleep statement
        Thread.sleep (3000);

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");

        //sleep statement
        Thread.sleep (1000);

        //click on bell icon
        driver.findElement(By.xpath( "//*[contains(@class,'rapid-nonanchor')]")).click();

        //wait 2 seconds
        Thread.sleep(2000);

        //quit chrome
        driver.quit();

    }//end of main
}//end of java class
