package Tests;

import Pages.MyntraSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyntraSearchTest {
    static WebDriver driver=null;
    public static void main(String args[]) throws InterruptedException {

        myntraSearch();

    }

    public static void myntraSearch() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\chromedriver.exe");
         driver = new ChromeDriver(options);
        driver.get("https://myntra.com");
        MyntraSearchPage.searchItem(driver).sendKeys("shirts");
        MyntraSearchPage.searchItem(driver).sendKeys(Keys.RETURN);

        Thread.sleep(6000);
        driver.close();
    }
}
