package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa.learning.model.ContactData;
import qa.learning.model.GroupData;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    public WebDriver driver;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    public void init() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("http://localhost/addressbook/");
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
        driver.quit();
    }

    public void fillGroupForm(GroupData groupData) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).sendKeys(groupData.name());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).sendKeys(groupData.header());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    public void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
    }

    public void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    public void gotoGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    public void gotoHomePage() {
      driver.findElement(By.linkText("home")).click();
    }

    public void fillContactForm(ContactData contactData) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).sendKeys(contactData.firstName());
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).sendKeys(contactData.secondName());
      driver.findElement(By.name("address")).click();
      driver.findElement(By.name("address")).sendKeys(contactData.address());
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).sendKeys(contactData.phone());
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).sendKeys(contactData.email());
    }

    public void submitContactCreation() {
      driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }

    public void initContactCreation() {
      driver.findElement(By.linkText("add new")).click();
    }
}
