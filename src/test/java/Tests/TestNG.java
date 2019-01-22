package Tests;

import config.PropertiesFile;
import Pages.MyntraPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
    WebElement element=null;
    public static String browserName=null;
    static WebDriver driver=null;
    @BeforeTest
    public void setupDriver(){
        String projectPath = System.getProperty("user.dir");
        PropertiesFile.getProperties();
        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            WebDriver driver=new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", projectPath + "\\src\\main\\resources\\geckodriver.exe");

        }


    }
    @Test
    public static void MyntraSeachTest(){
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get("https://myntra.com");
        searchPageObj.myntraSearchProduct("Shoes");
        searchPageObj.clickSearch();
        driver.close();

    }

    @AfterTest
    public void closeTest(){
        driver.quit();
        System.out.println("Test completed successfully");
    }
}
