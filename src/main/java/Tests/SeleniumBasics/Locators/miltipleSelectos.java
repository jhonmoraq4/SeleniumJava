package Tests.SeleniumBasics.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class miltipleSelectos {
    public static void main(String[] args) {

        String url = "https://demoqa.com/select-menu";
        System.setProperty("webdriver.chrome.driver",
                "\\Repositorio\\Selenium\\seleniumstartup\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().window().maximize();

        Select multiSelect = new Select(driver.findElement(By.name("cars")));
        multiSelect.selectByVisibleText("Saab");
        multiSelect.selectByIndex(0);
        multiSelect.selectByValue("audi");

    }
}
