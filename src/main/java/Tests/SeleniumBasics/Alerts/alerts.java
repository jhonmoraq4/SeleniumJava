package Tests.SeleniumBasics.Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class alerts {

    public static void main(String [] args) throws InterruptedException {
        String url = "https://demoqa.com/alerts";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()=\"Click me\"]"));

//        Thread.sleep(2000);
//        buttons.get(0).click();
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);

//        Thread.sleep(2000);
//        buttons.get(1).click();
//        Thread.sleep(6000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);

//        Thread.sleep(2000);
//        buttons.get(2).click();
//        Thread.sleep(2000);
//        driver.switchTo().alert().dismiss();
//        Thread.sleep(2000);


        Thread.sleep(2000);
        buttons.get(3).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("JoanMedia TestWDManager");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


    }

}
