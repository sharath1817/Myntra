import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String args[]) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        //driver.get("https://myntra.com");

       driver.get("https://www.myntra.com/login");
        //driver.findElement(By.name("email")).sendKeys("dasarisharath817@gmail.com");
        //driver.findElement(By.name("password")).sendKeys("sharath@123");
       //driver.findElement(By.className("login-login-button")).sendKeys(Keys.RETURN);
        //driver.get("https://www.myntra.com/register");
       //driver.findElement(By.id("male")).click();
       // driver.findElement(By.className("register-register-button")).sendKeys(Keys.RETURN);
        driver.findElement(By.className("desktop-searchBar")).sendKeys("Shirt");
        driver.findElement(By.className("desktop-searchBar")).sendKeys(Keys.RETURN);
        //driver.findElement(By.cssSelector("input[type='radio'][value='boys,boys girls'])")).click();
        List<WebElement> genderlist=driver.findElements(By.cssSelector(".gender-list .common-customRadio.gender-label"));
        //for(WebElement gender: genderlist) {
       // for(int i=0;i<genderlist.size();i++){
            WebElement localElement=genderlist.get(0);
            localElement.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //String value=localElement.getAttribute("value");
           // System.out.println("vacmlues from radio button"+value);

        //}
        driver.findElement(By.cssSelector("img[src*='8861518155061131-1']")).click();
        String parent=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();
        int count=allWindows.size();
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
        driver.findElement(By.className("desktop-cart")).click();
        //driver.switchTo().window(parent);




    }
}
