package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyntraSearchPage {
    static WebElement  element=null;
    public static WebElement searchItem(WebDriver driver) {
         element= driver.findElement(By.className("desktop-searchBar"));
        return element;
    }
}
