package Tests.SeleniumBasics.DragAndDrop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//#1 - Import Action and Action
import org.openqa.selenium.interactions.Actions;


public class dragAndDrop {

    public static void main(String [] args) throws InterruptedException {
        String url = "https://demoqa.com/droppable";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        //#2 - Instantiate the actions class
        Actions action = new Actions(driver);

        //#3 - Define the from and to
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        //#4 - User the method dragAndDrop
        //action.dragAndDrop(from, to).build().perform();

        //#5 - You can also use the X and Y properties
        action.dragAndDropBy(from, 225, 36).build().perform();


    }
}
