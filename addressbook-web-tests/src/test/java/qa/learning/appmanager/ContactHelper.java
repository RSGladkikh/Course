package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.learning.model.ContactData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstName());
        type(By.name("lastname"), contactData.secondName());
        type(By.name("address"), contactData.address());
        type(By.name("mobile"), contactData.phone());
        type(By.name("email"), contactData.email());
    }

    public void submitContactCreation() {
        driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }
}
