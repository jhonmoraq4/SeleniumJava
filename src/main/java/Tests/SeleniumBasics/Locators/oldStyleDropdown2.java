package Tests.SeleniumBasics.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class oldStyleDropdown2 {

    public static void main(String[] args) {

        String url = "https://demoqa.com/select-menu";
        System.setProperty("webdriver.chrome.driver",
                "\\Repositorio\\Selenium\\seleniumstartup\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().window().maximize();

        Select oldStyle = new Select(driver.findElement(By.id("oldSelectMenu")));
        // oldStyle.selectByIndex(1);
        // oldStyle.selectByValue("8");
        oldStyle.selectByVisibleText("Green");

    }

}
