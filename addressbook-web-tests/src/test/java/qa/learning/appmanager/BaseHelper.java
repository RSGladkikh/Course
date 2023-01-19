package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHelper {
    public WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
