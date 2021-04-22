package Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        //Initialize the webdriver
        WebDriver driver = new ChromeDriver();

        //Open the website
        driver.get("https://www.saucedemo.com/");

        //Maximize the webbrowser
        driver.manage().window().maximize();

        //Credentials
        String username = "standard_user";
        String password = "secret_sauce";

        //Locator by ID
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
//        WebElement loginBtn = driver.findElement(By.id("login-button"));

        //Locator by CLASS NAME
//        WebElement loginBtn = driver.findElement(By.className("submit-button"));

        //Locator by Name
//        WebElement loginBtn = driver.findElement(By.name("login-button"));

        //Locator by Xpath
//        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        //Locator by CSS Selector
        WebElement loginBtn = driver.findElement(By.cssSelector("input.submit-button"));

        //Login
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();



    }
}
