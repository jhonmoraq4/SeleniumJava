package Tests.SeleniumBasics.Waits;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

//import java.util.NoSuchElementException;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;



public class fluentWait {

    //Podemos especificar Cantidad de tiempo maxima de espera.
    //Podemos especificar Polling time(Peticiones)
    //Podemos espeficiar evitar una exepcion.

    public static void main(String [] args) throws InterruptedException {
        String url = "https://demoqa.com/dynamic-properties";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        driver.get(url);
        driver.manage().window().maximize();

        try{

            WebElement button = wait.until(new Function <WebDriver, WebElement>(){
                public WebElement apply(WebDriver driver){
                    return driver.findElement(By.id("visibleAfter"));
                }
            });

            button.click();
            System.out.printf("Click Hecho");

        }catch(Exception e){
            System.out.println(e);
        }

        driver.close();

    }
}
