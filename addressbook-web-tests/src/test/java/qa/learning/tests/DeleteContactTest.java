package qa.learning.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.learning.model.ContactData;
import qa.learning.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class DeleteContactTest extends TestBase{

    @BeforeTest
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Contactname").withLastName("Contactsurname").withAddress("world").withPhoneMobile("+79113332255").withEmail("test@mail.test"));
        }
    }

    @Test
    public void testDeleteContactTest() {

        Contacts before = app.contact().all();
        ContactData deletedContact = app.contact().all().iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(before.withoutDeleted(deletedContact), equalTo(after));



    }


}
