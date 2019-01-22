package Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoggerTest {
    static WebDriver driver=null;
    private static Logger logger= LogManager.getLogger(LoggerTest.class);
    public static void main(String args[]) throws InterruptedException {
        logger.trace("Tracing the test casse");
        logger.info("info massage");
        logger.error("error message");
        logger.warn("warn message");
        logger.fatal("fatal message");
        System.out.println("test completed");
        //myntraSearch();

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
