package Day06_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_Micalc {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("--kiosk");

        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //navigate to the mlcalc site
        driver.navigate().to("https://www.mlcalc.com");

        //sleep statement
        Thread.sleep(3000);

        //clear and enter a new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the purchase price
        pPrice.clear();
        //type new value on the purchase price
        pPrice.sendKeys("450000");

    }//end of main
}//end of class
