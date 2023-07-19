package Tests.SeleniumBasics.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators2 {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver",
                "\\Repositorio\\Selenium\\seleniumstartup\\src\\main\\resources\\drivers\\chromedriver.exe");

        // se inicializa el webdriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");

        driver.manage().window().maximize();

        String username = "standard_user";
        String password = "secret_sauce";

        // Locator by id
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        // WebElement loginButton = driver.findElement(By.id("login-button"));
        // WebElement loginButton = driver.findElement(By.className("summit-button"));
        // WebElement loginButton = driver.findElement(By.name("login-button"));
        // WebElement loginButton =
        // driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[contains(@type,'submit')]"));

        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

    }

}
