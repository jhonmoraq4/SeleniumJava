package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class oldStyleDropdown {

    public static void main(String [] args){

        String url = "https://demoqa.com/select-menu";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        //Instance of webdriver
        WebDriver driver = new ChromeDriver();

        //Enter to a website
        driver.get(url);

        //Maximize
        driver.manage().window().maximize();

        //Declare the Select Object

        Select oldStyleSelectMenu = new Select(driver.findElement(By.id("oldSelectMenu")));

        //Now we can select items depending on your needs
        oldStyleSelectMenu.selectByIndex(3);
//        oldStyleSelectMenu.selectByValue("2");
//        oldStyleSelectMenu.selectByVisibleText("aqua");





    }

}
