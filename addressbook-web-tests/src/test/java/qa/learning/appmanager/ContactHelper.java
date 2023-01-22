package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.learning.model.ContactData;

import static org.openqa.selenium.By.cssSelector;


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

    public void selectContact() { click(By.name("selected[]"));}

    public void initContactDeletion() { click(cssSelector("div:nth-child(8)"));}



    public void initContactEdit() { click(By.cssSelector("td:nth-child(8)"));}


    public void submitContactEdit() { click(By.cssSelector("input[type=submit]:nth-child(86)"));}

    public boolean isThereAContact() {
        return (isElementPresent(By.name("selected[]")));
    }
    public void createContact (ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

}
