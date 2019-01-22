package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyntraPageObjects {
    WebDriver driver=null;
    By product_search= By.className("desktop-searchBar");
    public MyntraPageObjects(WebDriver driver){
        this.driver=driver;
    }
    public void myntraSearchProduct(String text){
        driver.findElement(product_search).sendKeys(text);
    }
    public void clickSearch(){
        driver.findElement(product_search).sendKeys(Keys.RETURN);
    }
}
