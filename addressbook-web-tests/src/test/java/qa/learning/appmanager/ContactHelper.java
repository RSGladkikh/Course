package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.learning.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    public void submitCreation() {
        click(By.cssSelector("input:nth-child(87)"));
    }

    public void initCreation() {
        click(By.linkText("add new"));
    }

    public void selectByIndex(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }
    public void selectById(int id) {
        driver.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void initDeletion() {
        click(By.cssSelector("input[value=Delete]"));
    }



    public void initEdit(int id) {
        click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
    }


    public void submitEdit() { click(By.cssSelector("input[type=submit]:nth-child(86)"));}

    public boolean isThereAContact() {
        return (isElementPresent(By.name("selected[]")));
    }
    public void createContact (ContactData contact) {
        initCreation();
        fillContactForm(contact);
        submitCreation();
        returnToHomePage();
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }


    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cell = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cell.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = String.valueOf(cell.get(1).getText());
            String firstName = String.valueOf(cell.get(2).getText());
            String address = String.valueOf(cell.get(3).getText());
            String phone = String.valueOf(cell.get(4).getText());
            String email = String.valueOf(cell.get(5).getText());
            contacts.add(new ContactData()
                    .withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address).withPhoneMobile(phone).withEmail(email));
        }
        return contacts;
    }

    public void create(ContactData contact) {
        initCreation();
        fillContactForm(contact);
        submitCreation();
        returnToHomePage();
    }
    public void delete(ContactData contact) {
        selectById(contact.getId());
        initDeletion();
        driver.switchTo().alert().accept();
    }

    public  void edit(ContactData contact) {
        initEdit(contact.getId());
        fillContactForm(contact);
        submitEdit();
    }
}



