package qa.learning.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;


import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    private final Browser browser;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;
    public WebDriver driver;

    public ApplicationManager(Browser browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals(Browser.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }
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

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
