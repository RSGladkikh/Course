package qa.learning.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    private SessionHelper sessionHelper;
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
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        sessionHelper.logout();
        driver.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
