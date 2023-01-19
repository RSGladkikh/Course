package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.GroupData;

public class EditGroupTest extends TestBase{

    @Test
    public void editGroupTest() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupEdit();
        app.getGroupHelper().fillGroupForm(new GroupData("group1", "check", "that"));
        app.getGroupHelper().submitGroupEdit();
        app.getNavigationHelper().gotoGroupPage();




    }
}
