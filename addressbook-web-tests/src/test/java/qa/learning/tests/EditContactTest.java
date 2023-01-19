package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.ContactData;

public class EditContactTest extends TestBase{

    @Test
    public void editContactTest() {
        app.getContactHelper().initContactEdit();
        app.getContactHelper().fillContactForm(new ContactData("111", "222", "world", "+79113332255", "test@mail.test"));
        app.getContactHelper().submitContactEdit();
    }
}
