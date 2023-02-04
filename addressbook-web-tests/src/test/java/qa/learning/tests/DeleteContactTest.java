package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.ContactData;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class DeleteContactTest extends TestBase{

    @Test
    public void testDeleteContactTest() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstName("Contactname").withLastName("Contactsurname").withAddress("world").withPhoneMobile("+79113332255").withEmail("test@mail.test"));
        }
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = app.contact().all().iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));

        before.remove(deletedContact);
        assertThat(before, equalTo(after));



    }


}
