package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.learning.model.ContactData;

import java.util.ArrayList;
import java.util.List;



public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstName());
        type(By.name("lastname"), contactData.lastName());
        type(By.name("address"), contactData.address());
        type(By.name("mobile"), contactData.phoneMobile());
        type(By.name("email"), contactData.email());
    }

    public void submitContactCreation() {
        click(By.cssSelector("input:nth-child(87)"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void initContactDeletion() {
        click(By.cssSelector("input[value=Delete]"));
    }



    public void initContactEdit(int id) {
        click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
    }


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

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cell = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cell.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = String.valueOf(cell.get(1).getText());
            String firstName = String.valueOf(cell.get(2).getText());
            String address = String.valueOf(cell.get(3).getText());
            String phone = String.valueOf(cell.get(4).getText());
            String email = String.valueOf(cell.get(5).getText());
            ContactData contact = new ContactData(id, firstName, lastName, address, phone, email);
            contacts.add(contact);
            }
        return contacts;
    }
}



