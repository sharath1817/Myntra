package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import config.PropertiesFile;
import Pages.MyntraPageObjects;
import org.openqa.selenium.By;
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

import java.util.List;
import java.util.Set;

@Listeners(TestListernersDirectory.TestListerners.class)
public class TestNG {
    WebElement element=null;
    public static String browserName=null;
    public static String Username=null;
    public static String Password=null;
    public static String MobileNumber=null;


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
            driver.manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            WebDriver driver=new FirefoxDriver();
            System.setProperty("webdriver.firefox.marionette", projectPath + "\\src\\main\\resources\\GeckoDriverNew.exe");

        }
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Selecting the Browser","Chroem Browser");
        test1.pass("Browser selected Successfully");
        extent.flush();


    }
    @Test
    public static void MyntraUserRegister(){
        //Assert.assertTrue(false);
        System.out.println("I am inside TesRegister the user");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get("https://www.myntra.com/register");
        searchPageObj.MyntraEnterEmailID(Username);
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraEnterPassword(Password);
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraMobileNumber(MobileNumber);
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraMaleGenderSelect();
        searchPageObj.safeTimeOuts();
        searchPageObj.myntraRegisterButtonClick();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("New User Registration","User regiser");
        test1.pass("Registration Completed Successfully");
        extent.flush();



    }
    @Test(priority = 1)
    public static void MyntraLogin(){
        System.out.println("Sign In the User");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get("https://www.myntra.com/login");
        searchPageObj.MyntraEnterEmailID(Username);
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraEnterPassword(Password);
        searchPageObj.safeTimeOuts();
        searchPageObj.MytraLoginSubmit();
        searchPageObj.safeTimeOuts();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Sign In the user","sharath login");
        test1.pass("User Logged into the account");
        extent.flush();
        //throw new SkipException("this tast is skipped");


    }
    @Test(priority = 2)
    public static void MyntraSeachTest(){
        System.out.println("Searching Product");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get("https://myntra.com");
        searchPageObj.myntraSearchProduct("Watches");
        searchPageObj.clickSearch();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Searching the Product","Shirts");
        test1.pass("Shirts Product Serached successfully");
        extent.flush();


    }
    @Test(priority = 3)
    public void AddProductToTheCart() throws InterruptedException {

        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        System.out.println("Searching Product");
        driver.get("https://myntra.com");
        searchPageObj.myntraSearchProduct("Shirts");
        searchPageObj.clickSearch();
        searchPageObj.safeTimeOuts();
      searchPageObj.SelectShirt();
        searchPageObj.safeTimeOuts();
        System.out.println("passing through");
        //driver.findElement(By.cssSelector("img[src*='8861518155061131-1']")).click();
        Set<String> allWindows=driver.getWindowHandles();
        int count=allWindows.size();
        String parent=driver.getWindowHandle();
        String actualTitle;
        for(String child:allWindows){
            if(!parent.equalsIgnoreCase(child)){
                driver.switchTo().window(child);
                actualTitle = driver.getTitle();
                System.out.println("ActualTitle is +"+actualTitle);
                List<WebElement> size=driver.findElements(By.cssSelector(".size-buttons-unified-size"));
                for(WebElement size1: size) {
                    if(size1.getText().contains("38")) {
                        size1.click();
                        break;
                    }
                }
                driver.findElement(By.cssSelector(" .pdp-add-to-bag ")).click();
                Thread.sleep(3000);

            }
        }
        //driver.switchTo().window(parent);
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Adding Product to the Cart","Shirt is added to the cart");
        test1.pass("Adding Product to the cart test is passed successfully");
        extent.flush();

    }

    @Test(priority = 4)
    public void ShowCartItems(){
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get("https://www.myntra.com/");
        searchPageObj.ShowCart();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Showing cart Items","Displaying cart itmes");
        test1.pass("Displaying cart items test is passed successfully");
        extent.flush();

    }



    @AfterTest
    public void closeTest(){
        System.out.println("Closing the Driver");
        driver.quit();
        System.out.println("Test completed successfully");
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Closing the driver","Closing the driver");
        test1.pass("Browser selected Successfully");
        extent.flush();
    }

}
