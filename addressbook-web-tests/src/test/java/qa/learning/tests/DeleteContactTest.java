package qa.learning.tests;

import org.junit.Test;

public class DeleteContactTest extends TestBase{

    @Test
    public void deleteContactTest() {
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.driver.switchTo().alert().accept();
        app.getNavigationHelper().gotoHomePage();

    }
}
