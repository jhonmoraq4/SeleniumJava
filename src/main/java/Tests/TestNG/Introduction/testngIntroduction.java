package Tests.TestNG.Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//Tests.TestNG is a testing framework designed to simplify a broad range of testing needs,
// from unit testing (testing a class in isolation of the others) to integration testing
// (testing entire systems made of several classes, several packages and even several external
// frameworks, such as application servers).

//Default Selenium tests do not generate a proper format for the test results.
// Using Tests.TestNG in Selenium, we can generate test results.

//Advantages: Report Generation
//Grouping
//Annotations
//Prioritization
//Parallel Testing
//Uncaught exceptions are automatically handled by Tests.TestNG without terminating the test prematurely. These exceptions are reported as failed steps in the repor
public class testngIntroduction {

    private String url = "https://demoqa.com/";
    WebDriver driver;

    @BeforeTest
    public void setBaseUrl(){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
    }

    @Test
    public void titleTest(){
        String expectedTitle = "ToolsQA";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void urlTest(){

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, "test");

    }


    @AfterTest
    public void closeSession(){
        driver.quit();
    }
}
