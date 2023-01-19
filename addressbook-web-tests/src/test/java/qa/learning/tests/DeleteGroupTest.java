package qa.learning.tests;

import org.junit.Test;

public class DeleteGroupTest extends TestBase {

    @Test
    public void deleteGroupTest() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().groupDeletion();
        app.getNavigationHelper().gotoGroupPage();





    }


}
