package Tests.TestNG.Tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Set;

public class tabs {

    private String url = "https://demoqa.com/links";
    WebDriver driver;

    @BeforeMethod
    public void setBaseUrl(){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
    }

    @Test(priority=1)
    public void openNewTabUsingJS() throws InterruptedException {

        ((JavascriptExecutor)driver).executeScript("window.open();");
        Thread.sleep(5000);
    }

    @Test(priority=2)
    public void openNewTabCliking() throws InterruptedException {

        driver.findElement(By.id("simpleLink")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("dynamicLink")).click();
        Thread.sleep(5000);
        driver.get("https://www.google.com");
        Thread.sleep(15000);

    }

    @Test(priority=3)
    public void handleTabs()throws InterruptedException {

        //First Tab ID
        String mainTab = driver.getWindowHandle();
        String newTab = "";
        System.out.println("Current handle(String ID): " + mainTab);

        //Click on a button that opens a new tab
        driver.findElement(By.id("simpleLink")).click();
        Thread.sleep(5000);

        //Getting all the IDS and saving them on a SET of Strings
        Set<String> handles = driver.getWindowHandles();


        System.out.println("---- Printing all the tabs ID(and changing to the new tab opened ------");
        //Switching to another tab
        for(String actual : handles) {

            System.out.println("-- Handle ID: " + actual);

            if(!actual.equalsIgnoreCase(mainTab)) {
                System.out.println("-- Changing tab --");
                driver.switchTo().window(actual);
                newTab = actual;
            }
        }

        //Opening a new URL in the new tab
        driver.get("https://www.google.com");
        Thread.sleep(15000);

        driver.switchTo().window(mainTab);
        driver.get("https://www.google.com");
        Thread.sleep(15000);


    }

    @AfterMethod
    public void closeSession(){
        driver.quit();
    }

}
