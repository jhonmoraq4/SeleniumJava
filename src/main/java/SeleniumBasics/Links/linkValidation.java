package SeleniumBasics.Links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

//https://developer.mozilla.org/es/docs/Web/HTTP/Status

public class linkValidation {
    public static void main(String [] args) throws InterruptedException {
        String url = "https://demoqa.com/broken";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        WebElement validLink = driver.findElement(By.xpath("//*[contains(text(), 'Click Here for Valid Link')]"));
        WebElement invalidLink = driver.findElement(By.xpath("//*[contains(text(), 'Click Here for Broken Link')]"));

        HttpURLConnection http = null;
        int responseCode = 200;
        String src = "";

        src = invalidLink.getAttribute("href");

        System.out.println("Validating this src: " + src);

        try {
            http = (HttpURLConnection) (new URL(src).openConnection());
            http.setRequestMethod("HEAD");
            http.connect();

            responseCode = http.getResponseCode();
            System.out.println(responseCode);

            if (responseCode >= 400){
                System.out.println(src + " is a broken link");
            }else {
                System.out.println(src + " is NOT a broken link");
            }


        }catch (Exception e){
            System.out.println("Error Catched: " + e );
        }

        System.out.println("------------------ TODOS LOS LINKS ---------------");

        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
        Iterator<WebElement> links = listOfLinks.iterator();

        while (links.hasNext()){

            System.out.println("------------------ Checking A tag ---------------");

            src = links.next().getAttribute("href");

            if(src == null || src.isEmpty()){
                System.out.println("The url does not have a value or has a null value");
                continue;
            }

            try {
                http = (HttpURLConnection) (new URL(src).openConnection());
                http.setRequestMethod("HEAD");
                http.connect();

                responseCode = http.getResponseCode();
                System.out.println(responseCode);

                if (responseCode >= 400){
                    System.out.println(src + " is a broken link");
                }else {
                    System.out.println(src + " is NOT a broken link");
                }


            }catch (Exception e){
                System.out.println("Error Catched: " + e );
            }
        }

        System.out.println("------------------ All SeleniumBasics.Links Checked ---------------");

        driver.quit();

    }
}
