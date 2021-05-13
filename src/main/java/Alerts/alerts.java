package Alerts;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class alerts {

    public static void main(String [] args) throws InterruptedException {
        String url = "https://demoqa.com/alerts";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()=\"Click me\"]"));

        //Alert Case #1
//        Thread.sleep(2000);
//        buttons.get(0).click();
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);

        //Alert Case #2
//        Thread.sleep(2000);
//        buttons.get(1).click();
//        Thread.sleep(5500);
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);

        //Confirmation Box #3

        Thread.sleep(2000);
        buttons.get(2).click();
        Thread.sleep(5500);
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        //Confirmation Box #4
        Thread.sleep(2000);
        buttons.get(3).click();
        Thread.sleep(5500);
        driver.switchTo().alert().sendKeys("JoanMedia Test");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);





    }

}
