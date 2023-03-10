package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class BaseHelper {
    public WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text) {

        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                click(locator);
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);

            }
        }
    }

    public void attach(By locator, File file) {

        if (file != null) {
            driver.findElement(locator).sendKeys(file.getAbsolutePath());

            }
        }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent (By locator) {
        try {
        driver.findElement(locator);
        return true;
    } catch (NoSuchElementException ex) {
        return false;
        }
}
}
