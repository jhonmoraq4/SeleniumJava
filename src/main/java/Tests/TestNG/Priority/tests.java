package Tests.TestNG.Priority;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tests {

    private String url = "https://demoqa.com/links";
    WebDriver driver;

    @BeforeMethod
    public void setBaseUrl(){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
    }

    @Test
    public void dMethod(){
        System.out.println("I am D Method");
    }

    @Test
    public void cMethod(){
        System.out.println("I am C Method");
    }

    @Test
    public void bMethod(){
        System.out.println("I am B Method");
    }

    @Test
    public void aMethod(){
        System.out.println("I am A Method");
    }



    @AfterMethod
    public void closeSession(){
        driver.quit();
    }
}
