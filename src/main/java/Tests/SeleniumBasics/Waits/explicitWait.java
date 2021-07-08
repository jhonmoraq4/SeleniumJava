package Tests.SeleniumBasics.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWait {

    //-> Permite esperar por condiciones esperadas. +Inteligente.
    //-> Polling time -> 250 MS

    public static void main(String [] args) throws InterruptedException {
        String url = "https://demoqa.com/dynamic-properties";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait  wait = new WebDriverWait(driver, 10);

        driver.get(url);
        driver.manage().window().maximize();

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
            driver.findElement(By.id("visibleAfter")).click();
            System.out.println("Boton Clickeado");
        }catch(Exception e){
            System.out.println(e);
        }

        driver.close();

    }

}
