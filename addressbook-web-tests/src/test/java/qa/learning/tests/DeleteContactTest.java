package qa.learning.tests;

import org.junit.Assert;
import org.junit.Test;
import qa.learning.model.ContactData;

import java.util.List;

public class DeleteContactTest extends TestBase{

    @Test
    public void testDeleteContactTest() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Contactname", "Contactsurname", "world", "+79113332255", "test@mail.test"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().initContactDeletion();
        app.driver.switchTo().alert().accept();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() - 1, after.size());

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);



    }
}
