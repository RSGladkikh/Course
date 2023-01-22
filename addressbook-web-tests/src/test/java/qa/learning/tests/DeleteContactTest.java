package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.ContactData;

public class DeleteContactTest extends TestBase{

    @Test
    public void testDeleteContactTest() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Contactname", "Contactsurname", "world", "+79113332255", "test@mail.test"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.driver.switchTo().alert().accept();
        app.getNavigationHelper().gotoHomePage();

    }
}
