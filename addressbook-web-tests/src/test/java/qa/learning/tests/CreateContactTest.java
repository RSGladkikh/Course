package qa.learning.tests;// Generated by Selenium IDE


import org.testng.annotations.Test;
import qa.learning.model.ContactData;
import qa.learning.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class CreateContactTest extends TestBase {

  @Test(enabled = false)
  public void testCreateContact() {
    app.goTo().homePage();
    File photo = new File("src/test/java/qa/learning/resources/cat.jpg");
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Contactname").withLastName("Contactsurname").withAddress("world").withEmail("test@mail.test")
            /*.withPhoneHome("+7(911)3332251")*/.withPhoneMobile("+7-911-333-22-52")/*.withPhoneWork("+7 911 333 22 55")*/
            .withPhoto(photo);
    app.contact().create(contact);
    assertThat(before.size() + 1, equalTo(app.contact().count()));
    Contacts after = app.contact().all();
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    assertThat(before.withAdded(contact), equalTo(after));
  }




}
