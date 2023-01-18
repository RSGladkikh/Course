package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void login(String username, String password) {
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    protected void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }
}
