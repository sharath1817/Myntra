import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String args[]) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://myntra.com");
        driver.findElement(By.className("desktop-searchBar")).sendKeys("Shirt");
        driver.findElement(By.className("myntraweb-sprite desktop-iconSearch sprites-search")).click();


    }
}
