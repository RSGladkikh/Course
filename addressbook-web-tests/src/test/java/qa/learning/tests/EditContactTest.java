package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.ContactData;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class EditContactTest extends TestBase{

    @Test
    public void testEditContactTest() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstName("Contactname").withLastName("Contactsurname").withAddress("world").withPhoneMobile("+79113332255").withEmail("test@mail.test"));
        }
        Set<ContactData> before = app.contact().all();
        ContactData editedContact = app.contact().all().iterator().next();
        ContactData contact = new ContactData()
                .withId(editedContact.getId()).withFirstName("E111").withLastName("E222").withAddress("Eworld").withPhoneMobile("+79113332266").withEmail("Etest@mail.test");
        app.contact().edit(editedContact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        assertThat(before.size(), equalTo(after.size()));

        before.remove(editedContact);
        before.add(contact);

        assertThat(before, equalTo(after));




    }


}

