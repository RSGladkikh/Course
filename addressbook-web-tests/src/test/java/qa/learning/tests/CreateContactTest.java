package qa.learning.tests;// Generated by Selenium IDE
import org.junit.Test;
import qa.learning.model.ContactData;


public class CreateContactTest extends TestBase {

  @Test
  public void createContact() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Contactname", "Contactsurname", "world", "+79113332255", "test@mail.test"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }

}
