package Pages;

import Pages.MyntraPageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyntraSeachPageTest {
    WebElement element=null;
    private static WebDriver driver=null;
    public static void main(String args[]){

        MyntraSeachTest();

    }
    public static void MyntraSeachTest(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        ExtentReports extent= new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Search Product","Myntra Product Seach Test Validation");
        String projectPath = System.getProperty("user.dir");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        test1.log(Status.INFO, "Starting Test Case");
        driver.get("https://myntra.com");
        test1.pass("navigated to Myntra site");

        searchPageObj.myntraSearchProduct("Shoes");
        test1.pass("Shoe searched");
        searchPageObj.clickSearch();
        test1.pass("Click action is completed");
        driver.close();
        test1.info("Test completed successfully");
        extent.flush();

    }
}
