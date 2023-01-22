package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.ContactData;

public class EditContactTest extends TestBase{

    @Test
    public void testEditContactTest() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Contactname", "Contactsurname", "world", "+79113332255", "test@mail.test"));
        }
        app.getContactHelper().initContactEdit();
        app.getContactHelper().fillContactForm(new ContactData("E111", "E222", "Eworld", "+79113332266", "Etest@mail.test"));
        app.getContactHelper().submitContactEdit();
    }
}

