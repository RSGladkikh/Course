package qa.learning.tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.learning.model.ContactData;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDetailsTest extends TestBase{
    @BeforeTest
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Contactname").withLastName("Contactsurname").withAddress("world")
                    .withPhoneMobile("+79113332255").withEmail("test@mail.test"));
        }
    }

    @Test(enabled = false)
    public void contactDetailsTest(){
        ContactData contact = app.contact().all().iterator().next();
        String details = clean(app.contact().contactDetails(contact));
        app.goTo().homePage();
        assertThat(details, equalTo(mergeContactData(app.contact().infoFromEditForm(contact))));
    }


    public static String clean(String info){
        return info.replaceAll("\nH:","").replaceAll("\nM:","")
                .replaceAll("\nW:","").replaceAll("\\s", "");
    }
    public String mergeContactData(ContactData contact){
        return Stream.of(contact.firstName(), contact.lastName(), contact.address(), contact.phoneHome(), contact.phoneMobile(),
                contact.phoneWork(), contact.email(), contact.email2(), contact.email3()).filter((s) -> ! s.equals(""))
                .map(ContactDetailsTest::clean).collect(Collectors.joining());
    }
}
