package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.GroupData;

public class DeleteGroupTest extends TestBase {

    @Test
    public void testDeleteGroupTest() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("group1", "111", "222"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().groupDeletion();
        app.getNavigationHelper().gotoGroupPage();





    }


}
