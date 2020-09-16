package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        // Initialize browser
        WebDriver driver = new ChromeDriver();

        // Open facebook
        driver.get("http://www.facebook.com");

        // Maximize browser

        driver.manage().window().maximize();
        driver.close();

    }
}
