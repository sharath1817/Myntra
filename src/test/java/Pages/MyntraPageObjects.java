package Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MyntraPageObjects {
    private WebDriver driver;
    private By product_search= By.className("desktop-searchBar");
    private By EnterEmailID=By.name("email");
    private By EnterPassword=By.name("password");
    private By LoginSubmit=By.className("login-login-button");
    private By EnterMobileNumber=By.name("mobile");
    private By MaleGender=By.id("male");
    private By FemaleGender=By.id("female");
    private By ReigsterButtonClick=By.className("register-register-button");
    public MyntraPageObjects(WebDriver driver){

        this.driver=driver;
    }
    public void safeTimeOuts(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void myntraSearchProduct(String text){
        driver.findElement(product_search).sendKeys(text);
    }
    public void clickSearch(){
        driver.findElement(product_search).sendKeys(Keys.RETURN);
    }
    public void MyntraEnterEmailID(String emailID){
        driver.findElement(EnterEmailID).sendKeys(emailID);
    }
    public void MyntraEnterPassword(String password){
        driver.findElement(EnterPassword).sendKeys(password);
    }
    public void MytraLoginSubmit()
    {
        driver.findElement(LoginSubmit).sendKeys(Keys.RETURN);
    }

   public void MyntraMobileNumber(String MobileNumber){
        driver.findElement(EnterMobileNumber).sendKeys(MobileNumber);
   }
   public void MyntraMaleGenderSelect(){
       driver.findElement(MaleGender).click();
   }
    public void MyntraFemaleGenderSelect(){
        driver.findElement(FemaleGender).click();
    }
    public void myntraRegisterButtonClick(){
        driver.findElement(ReigsterButtonClick).sendKeys(Keys.RETURN);
    }
    public void HtmlReportGeneration(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        ExtentReports extent= new ExtentReports();
        extent.attachReporter(htmlReporter);

    }
    public void MaximizeTheBrowser(){
        driver.manage().window().maximize();
    }
}
