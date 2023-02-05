package qa.learning.tests;

import org.junit.Before;
import org.junit.Test;
import qa.learning.model.ContactData;
import qa.learning.model.Contacts;

import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class EditContactTest extends TestBase{

    @Before
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Contactname").withLastName("Contactsurname").withAddress("world").withPhoneMobile("+79113332255").withEmail("test@mail.test"));
        }
    }

    @Test
    public void testEditContactTest() {

        Contacts before = app.contact().all();
        ContactData editedContact = app.contact().all().iterator().next();
        ContactData contact = new ContactData()
                .withId(editedContact.getId()).withFirstName("E111").withLastName("E222").withAddress("Eworld").withPhoneMobile("+79113332266").withEmail("Etest@mail.test");
        app.contact().edit(editedContact);
        app.goTo().homePage();
        assertThat(before.size(), equalTo(app.contact().count()));
        Contacts after = app.contact().all();
        assertThat(before.withEdited(editedContact, contact), equalTo(after));




    }


}

