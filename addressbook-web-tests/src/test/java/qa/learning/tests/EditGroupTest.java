package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.GroupData;

public class EditGroupTest extends TestBase{

    @Test
    public void testEditGroupTest() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("group1", "111", "222"));
        };
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupEdit();
        app.getGroupHelper().fillGroupForm(new GroupData("group1Edited", "222", "333"));
        app.getGroupHelper().submitGroupEdit();
        app.getNavigationHelper().gotoGroupPage();




    }
}
