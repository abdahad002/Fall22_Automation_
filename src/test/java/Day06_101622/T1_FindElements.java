package Day06_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {

    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("--kiosk");

        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //navigate to the google site
        driver.navigate().to("https://www.yahoo.com");

        //sleep statement
        Thread.sleep(3000);

        //using find elements I want to click on second link within the group which is "News"
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();

    }//end of main
}//end of java class
