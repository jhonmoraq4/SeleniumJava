package Tests.TestNG.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class TestWDManager {

    private String url = "https://demoqa.com/links";
    WebDriver driver;

    //https://github.com/bonigarcia/webdrivermanager#basic-usage

    @BeforeMethod
    public void setBaseUrl(){

        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
//        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver = new EdgeDriver();


        driver.get(url);
    }

    @Test(priority=1)
    public void openNewTabUsingJS() throws InterruptedException {

        ((JavascriptExecutor)driver).executeScript("window.open();");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeSession(){
        driver.quit();
    }

}

