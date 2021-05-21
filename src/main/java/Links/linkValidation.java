package Links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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


        WebElement validLink = driver.findElement(By.xpath("//*[contains(text(),'Click Here for Valid Link')]"));
        WebElement brokenLink = driver.findElement(By.xpath("//*[contains(text(),'Click Here for Broken Link')]"));

        //Each HttpURLConnection instance is used to make a single request but the underlying network connection
        // to the HTTP server may be transparently shared by other instances.
        HttpURLConnection huc = null;
        int responseCode = 200;
        //200 OK-La solicitud ha tenido éxito.
        //500 Internal Server Error-El servidor ha encontrado una situación que no sabe cómo manejarla.
        //400 Bad Request - Esta respuesta significa que el servidor no pudo interpretar la solicitud dada una sintaxis inválida.
        String src = "";

        System.out.println("Validating a valid link");
        src = brokenLink.getAttribute("href");
        System.out.println("HREF: " + src);

        try {

            huc = (HttpURLConnection)(new URL(src).openConnection());

            huc.setRequestMethod("HEAD");

            huc.connect();

            responseCode = huc.getResponseCode();

            if(responseCode >= 400){
                System.err.println(src +" is a broken link");
            }
            else{
                System.out.println(src +" is a valid link");
            }

        }catch (Exception e){
            System.out.println("Exception catched: " + e);
        }

        //Check All links

        System.out.println("Checking all Links");

        List<WebElement> linkList = driver.findElements(By.tagName("a"));

        Iterator<WebElement> links = linkList.iterator();

        while (links.hasNext()){
            src = links.next().getAttribute("href");

            if(src == null || src.isEmpty()){
                System.out.println("The url does not have a value or it is set to null");
                continue;
            }
            else{
                try {

                    huc = (HttpURLConnection)(new URL(src).openConnection());

                    huc.setRequestMethod("HEAD");

                    huc.connect();

                    responseCode = huc.getResponseCode();

                    if(responseCode >= 400){
                        System.err.println(src +" is a broken link");
                    }
                    else{
                        System.out.println(src +" is a valid link");
                    }

                }catch (Exception e){
                    System.out.println("Exception catched: " + e);
                }
            }

        }

        driver.quit();

    }
}
