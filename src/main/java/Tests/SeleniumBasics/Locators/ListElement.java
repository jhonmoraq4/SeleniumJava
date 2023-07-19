package Tests.SeleniumBasics.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListElement {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver",
                "\\Repositorio\\Selenium\\seleniumstartup\\src\\main\\resources\\drivers\\chromedriver.exe");

        // se inicializa el webdriver
        WebDriver driver = new ChromeDriver();
        String url = "https://www.saucedemo.com";
        driver.get(url);

        driver.manage().window().maximize();

        String username = "standard_user";
        String password = "secret_sauce";

        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        for (int i = 0; i < inputs.size(); i++) {
            if (i == 0) {
                inputs.get(i).sendKeys(username);
            }
            if (i == 1) {
                inputs.get(i).sendKeys(password);
            } else if (i == 2) {
                inputs.get(i).click();
                ;
            }

            driver.close();

        }
    }
}