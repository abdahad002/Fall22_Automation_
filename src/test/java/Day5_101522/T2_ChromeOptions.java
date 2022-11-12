package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("--kiosk");
        options.addArguments("incognito");
        options.addArguments("headless");

        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //navigate to the google site
        driver.navigate().to("https://www.google.com");

        //sleep statement
        Thread.sleep (3000);

        //search a keyword on the search field
        //relative xpath to locate the element
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //sleep statement
        Thread.sleep(3000);

        //capture the search result text
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //split message to extract out the search number
        String[] splitResult = result.split(" ");
        System.out.println("the search number is " + splitResult[1]);

        //quit the driver to end the session
        driver.quit();
    }//end of main
}//end of java class

