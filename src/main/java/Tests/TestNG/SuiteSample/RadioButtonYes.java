package Tests.TestNG.SuiteSample;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonYes {

    private String url = "https://demoqa.com/radio-button";
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setBaseUrl(){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
    }

    @Test(groups = {"URL"})
    public void verifyUrl(){
        String expectedTitle = "ToolsQA";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(groups = {"CLICK"})
    public void clickYes(){

//        driver.findElement(By.id("yesRadio")).click();
        WebElement element = driver.findElement(By.id("yesRadio"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        String response = driver.findElement(By.className("text-success")).getText();
        System.out.println("The response was: " + response);

        Assert.assertEquals(response, "Yes");

    }





    @AfterMethod(alwaysRun = true)
    public void closeSession(){
        driver.quit();
    }

}
