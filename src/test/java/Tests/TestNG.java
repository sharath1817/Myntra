package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import config.PropertiesFile;
import Pages.MyntraPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListernersDirectory.TestListerners.class)
public class TestNG {
    WebElement element=null;
    public static String browserName=null;
    private static WebDriver driver=null;
    private static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    private static ExtentReports extent= new ExtentReports();

    @BeforeTest()
    public void setupDriver(){
        System.out.println("Setting Up the driver");
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
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Selecting the Browser","Chroem Browser");
        extent.flush();


    }
    @Test
    public static void MyntraSeachTest(){
        System.out.println("Searching Product");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get("https://myntra.com");
        searchPageObj.myntraSearchProduct("Shoes");
        searchPageObj.clickSearch();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Searching the Product","Shoes");
        extent.flush();


    }
    @Test
    public static void MyntraLogin(){
        System.out.println("Sign In the User");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get("https://www.myntra.com/login");
        searchPageObj.MyntraEnterEmailID("dasarisharath1817@gmail.com");
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraEnterPassword("sharath@123");
        searchPageObj.safeTimeOuts();
        searchPageObj.MytraLoginSubmit();
        searchPageObj.safeTimeOuts();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Sign In the user","sharath login");
        extent.flush();
        throw new SkipException("this tast is skipped");


    }
    @Test
    public static void MyntraUserRegister(){
        //Assert.assertTrue(false);
        System.out.println("I am inside TesRegister the user");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get("https://www.myntra.com/register");
        searchPageObj.MyntraEnterEmailID("dasarisharath1817@gmail.com");
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraEnterPassword("sharath@123");
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraMobileNumber("9912224869");
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraMaleGenderSelect();
        searchPageObj.safeTimeOuts();
        searchPageObj.myntraRegisterButtonClick();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("New User Registration","User regiser");
        extent.flush();



    }

    @AfterTest
    public void closeTest(){
        System.out.println("Closing the Driver");
        driver.quit();
        System.out.println("Test completed successfully");
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Closing the driver","Closing the driver");
        extent.flush();
    }

}
