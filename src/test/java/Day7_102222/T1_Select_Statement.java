package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Statement {
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
        //navigate to the google site
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement strtMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select strtMonthDropDown = new Select(strtMonth);
        //select by visible text
        strtMonthDropDown.selectByVisibleText("Nov");


        //another method
        //driver.findElement(By.xpath("//*[@name='sy']")).click();
       // driver.findElement(By.xpath("//*[text()='2023']")).click();


    }//end of main
}//end of class
