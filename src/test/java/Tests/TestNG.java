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
import test.tmp.Base;

import java.util.List;
import java.util.Set;

@Listeners(TestListernersDirectory.TestListerners.class)
public class TestNG {
    WebElement element=null;
    public static String browserName=null;
    public static String Username=null;
    public static String Password=null;
    public static String MobileNumber=null;
    public static String Base_URL=null;


    private static WebDriver driver=null;
    private static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("MyntraResults.html");
    private static ExtentReports extent= new ExtentReports();


    @BeforeTest()
    public void setupDriver(){
        System.out.println("Setting Up the driver");
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Selecting the Browser","Chrome Browser");
        String projectPath = System.getProperty("user.dir");
        PropertiesFile.getProperties();
        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            test1.pass("Disabled Notifications of Chrome Browser successfully");
            System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            test1.pass("Maximized Chrome Browser Successfully");
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            WebDriver driver=new FirefoxDriver();
            System.setProperty("webdriver.firefox.marionette", projectPath + "\\src\\main\\resources\\GeckoDriverNew.exe");

        }

        test1.pass("Browser selected Successfully");


    }
    @Test
    public static void MyntraUserRegister(){
        //Assert.assertTrue(false);
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("New User Registration","User regiser");
        System.out.println("I am inside TesRegister the user");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get(Base_URL+"/register");
        test1.pass("Navigated to the Registration Page successfully");
        searchPageObj.MyntraEnterEmailID(Username);
        searchPageObj.safeTimeOuts();
        test1.pass("Username entered Successfully");
        searchPageObj.MyntraEnterPassword(Password);
        searchPageObj.safeTimeOuts();
        test1.pass("Password entered Successfully");
        searchPageObj.MyntraMobileNumber(MobileNumber);
        searchPageObj.safeTimeOuts();
        test1.pass("Mobile Number entered Successfully");
        searchPageObj.MyntraMaleGenderSelect();
        searchPageObj.safeTimeOuts();
        test1.pass("Gender Selected Successfully");
        searchPageObj.myntraRegisterButtonClick();
        test1.pass("Registration Button clicked successfully");
        test1.pass("Registration Completed Successfully");




    }
    @Test(priority = 1)
    public static void MyntraLogin(){
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Sign In the user","sharath login");
        System.out.println("Sign In the User");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get(Base_URL+"/login");
        test1.pass("Navigated to Myntra Login Page successfully");
        searchPageObj.MyntraEnterEmailID(Username);
        test1.pass("Username Entered Successfully");
        searchPageObj.safeTimeOuts();
        searchPageObj.MyntraEnterPassword(Password);
        test1.pass("Password Entered Successfully");
        searchPageObj.safeTimeOuts();
        searchPageObj.MytraLoginSubmit();
        test1.pass("Submit button clicked Successfully");
        searchPageObj.safeTimeOuts();

        test1.pass("User Logged into the account");
        //throw new SkipException("this tast is skipped");


    }
    @Test(priority = 2)
    public static void MyntraSeachTest(){
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Searching the Product","Watches");
        System.out.println("Searching Product");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get(Base_URL);
        test1.pass("Navigated to Myntra Website");
        searchPageObj.myntraSearchProduct("Watches");
        test1.pass("Entered 'Watches' in search Box successfully");
        searchPageObj.clickSearch();
        test1.pass("Shirts Product Serached successfully");



    }
    @Test(priority = 3)
    public void AddProductToTheCart() throws InterruptedException {
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Adding Product to the Cart","Shirt is added to the cart");
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        System.out.println("Searching Product");
        driver.get(Base_URL);
        test1.pass("Navigated to Myntra Website sucessfully");
        searchPageObj.myntraSearchProduct("Shirts");
        test1.pass("Shirts Product searched");
        searchPageObj.clickSearch();
        searchPageObj.safeTimeOuts();
      searchPageObj.SelectShirt();
        test1.pass("Shirts is selected and New tab is opened");
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
                test1.pass("Navigated to Newly opened Tab");
                actualTitle = driver.getTitle();
                System.out.println("ActualTitle is +"+actualTitle);
                test1.pass("New Window title is printed on console");
                List<WebElement> size=driver.findElements(By.cssSelector(".size-buttons-unified-size"));
                for(WebElement size1: size) {
                    if(size1.getText().contains("42")) {
                        size1.click();
                        break;
                    }
                }
                test1.pass("Selected Shirt size as 38 ");
                searchPageObj.AddCartButtonClick();
                test1.pass("Shirt is added to the cart successfully");
                Thread.sleep(3000);

            }
        }
        //driver.switchTo().window(parent);

    }

    @Test(priority = 4)
    public void ShowCartItems(){
        MyntraPageObjects searchPageObj=new MyntraPageObjects(driver);
        driver.get(Base_URL);
        searchPageObj.ShowCart();
        extent.attachReporter(htmlReporter);
        ExtentTest test1= extent.createTest("Showing cart Items","Displaying cart itmes");
        test1.pass("Displaying cart items test is passed successfully");


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
