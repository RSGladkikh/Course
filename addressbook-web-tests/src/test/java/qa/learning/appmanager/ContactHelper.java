package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.learning.model.ContactData;
import qa.learning.model.Contacts;

import java.util.List;


public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstName());
        type(By.name("lastname"), contactData.lastName());
        type(By.name("address"), contactData.address());
        type(By.name("home"), contactData.phoneHome());
        type(By.name("mobile"), contactData.phoneMobile());
        type(By.name("work"), contactData.phoneWork());
        type(By.name("email"), contactData.email());
    }

    public void submitCreation() {
        click(By.cssSelector("input:nth-child(87)"));
    }

    public void initCreation() {
        click(By.linkText("add new"));
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
    public void detailsPage(int id) {
        click(By.cssSelector("a[href='view.php?id=" + id + "']"));
    }


    public void submitEdit() { click(By.cssSelector("input[type=submit]:nth-child(86)"));}

    public boolean isThereAContact() {
        return (isElementPresent(By.name("selected[]")));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Contacts contactsCache = null;


    public Contacts all() {
        if (contactsCache != null){
            return new Contacts(contactsCache);
        }
        Contacts contactsCache = new Contacts();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cell = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cell.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cell.get(1).getText();
            String firstName = cell.get(2).getText();
            String address = cell.get(3).getText();
            String email = cell.get(4).getText();
            String allPhones = cell.get(5).getText();

            contactsCache.add(new ContactData()
                    .withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address)
                    .withAllPhones(allPhones).withEmail(email));
        }
        return contactsCache;
    }

    public ContactData infoFromEditForm (ContactData contact){
        initEdit(contact.getId());
        String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getAttribute("value");
        String phoneHome = driver.findElement(By.name("home")).getAttribute("value");
        String phoneMobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String phoneWork = driver.findElement(By.name("work")).getAttribute("value");
        String email = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");
        return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
                .withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3).withPhoneHome(phoneHome).withPhoneMobile(phoneMobile)
                .withPhoneWork(phoneWork);

    }

    public void create(ContactData contact) {
        initCreation();
        fillContactForm(contact);
        submitCreation();
        contactsCache = null;
        returnToHomePage();
    }
    public void delete(ContactData contact) {
        selectById(contact.getId());
        initDeletion();
        driver.switchTo().alert().accept();
        contactsCache = null;
    }

    public  void edit(ContactData contact) {
        initEdit(contact.getId());
        fillContactForm(contact);
        submitEdit();
        contactsCache = null;
    }

    public String contactDetails(ContactData contact){
        detailsPage(contact.getId());
        String details = driver.findElement(By.id("content")).getText();

        return details;

    }


}



