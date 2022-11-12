package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearchExample {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to the google site
        driver.navigate().to("https://www.google.com");

        //maximize my window
        //for windows
        //driver.manage().window().maximize();
        //for mac
        driver.manage().window().fullscreen();

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
