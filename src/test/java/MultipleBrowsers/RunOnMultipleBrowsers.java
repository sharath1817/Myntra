package MultipleBrowsers;

import config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RunOnMultipleBrowsers {
    WebDriver driver=null;
    @Parameters("BroName")
    @BeforeTest
    public void setup(String BroName){
        String projectPath = System.getProperty("user.dir");
        PropertiesFile.getProperties();
        System.out.println("Browser name is:"+BroName);
        if(BroName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver(options);
        }
            System.setProperty("webdriver.gecko.driver", projectPath + "\\src\\main\\resources\\geckodriver.exe");

        }

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(6000);
    }

    public void CloseTheTest()
    {
        driver.close();
        System.out.println("Test completed successfully");
    }
}
