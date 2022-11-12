package Day06_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_mlcalc_forloop {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        // add the options for maximizing the chrome meeting
        // options.addArguments("start-fullscreen") for mac
        options.addArguments("start-fullscreen");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //create sets of array list for purchase price, down payment, interest rate
        ArrayList<String> purchasePrice, downPayment, interestRate;
        purchasePrice = new ArrayList<>();
        purchasePrice.add("350000");
        purchasePrice.add("370000");
        purchasePrice.add("380000");

        //down payment arraylist
        downPayment = new ArrayList<>();
        downPayment.add("25");
        downPayment.add("30");
        downPayment.add("35");

        //interestRate
        interestRate = new ArrayList<>();
        interestRate.add("3.4");
        interestRate.add("4.1");
        interestRate.add("2.8");


        for (int i = 0; i < interestRate.size(); i++) {
            //navigate to the google site
            driver.navigate().to("https://www.mlcalc.com");

            //sleep statement
            Thread.sleep(3000);

            //clear and enter a new value on purchase price field
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));

            //clear the purchase price
            pPrice.clear();
            //type new value on the purchase price
            pPrice.sendKeys(purchasePrice.get(i));

            //clear and enter a new value on down payment field
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            //clear the down payment
            dPayment.clear();
            //type new value on the down payment
            dPayment.sendKeys(downPayment.get(i));

            //clear and enter a new value on interest rate field
            WebElement intRate = driver.findElement(By.xpath("//*[@name='ir']"));
            //clear the down payment
            intRate.clear();
            //type new value on the down payment
            intRate.sendKeys(interestRate.get(i));

            //click on calculate button
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();

            Thread.sleep(3000);

            //capture and print monthly payment value
            String mntPayment = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
            System.out.println("Monthly payment: " + mntPayment);

        }//end of for loop
    }//end main

}//end of class
