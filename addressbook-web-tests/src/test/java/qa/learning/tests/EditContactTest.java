package qa.learning.tests;

import org.junit.Assert;
import org.junit.Test;
import qa.learning.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class EditContactTest extends TestBase{

    @Test
    public void testEditContactTest() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Contactname", "Contactsurname", "world", "+79113332255", "test@mail.test"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactEdit(before.get(before.size() - 1).getId());
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"E111", "E222", "Eworld", "+79113332266", "Etest@mail.test");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactEdit();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);




    }
}

