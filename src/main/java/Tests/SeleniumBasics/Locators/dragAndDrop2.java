package Tests.SeleniumBasics.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class dragAndDrop2 {

    public static void main(String[] args) {

        String url = "https://demoqa.com/droppable";

        System.setProperty("webdriver.chrome.driver",
                "\\Repositorio\\Selenium\\seleniumstartup\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));

        action.dragAndDrop(from, to).build().perform();

    }

}
