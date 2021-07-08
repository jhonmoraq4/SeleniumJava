package Tests.SeleniumBasics.FindElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class findElements {

    public static void main(String [] args){

        String url = "https://www.saucedemo.com/";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        //Instance of webdriver
        WebDriver driver = new ChromeDriver();

        //Enter to a website
        driver.get(url);

        //Maximize
        driver.manage().window().maximize();

        //Credentials
        String username = "standard_user";
        String password = "secret_sauce";

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("Cuantos elementos hemos encontrado? " + inputs.size());

        for(int i = 0; i < inputs.size(); i++){
          if(i == 0){
              inputs.get(i).sendKeys(username);
          }else if(i == 1){
              inputs.get(i).sendKeys(password);
          }else{
              inputs.get(i).click();
          }
        }

        //driver.close();
    }

}
