package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    private ContactHelper contactHelper;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;
    public WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("http://localhost/addressbook/");
        navigationHelper = new NavigationHelper(driver);
        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        login("admin", "secret");
    }

    private void login(String username, String password) {
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    public void stop() {
        logout();
        driver.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    private void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
