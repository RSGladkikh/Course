package qa.learning.tests;

import org.junit.Before;
import org.junit.Test;
import qa.learning.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhonesTest extends TestBase {

    @Before
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Contactname").withLastName("Contactsurname").withAddress("world").withPhoneMobile("+79113332255").withEmail("test@mail.test"));
        }
    }

    @Test
    public void contactPhonesTest () {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.allPhones(), equalTo(mergePhones(contactFromEditForm)));

    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

    public String mergePhones(ContactData contact){
        return Stream.of(contact.phoneHome(), contact.phoneMobile(), contact.phoneWork()).filter((s) -> ! s.equals(""))
                .map(ContactPhonesTest::cleaned)
                .collect(Collectors.joining("\n"));
    }







}
