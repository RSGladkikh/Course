package qa.learning.tests;

import org.junit.Assert;
import org.junit.Test;
import qa.learning.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class DeleteGroupTest extends TestBase {

    @Test
    public void testDeleteGroupTest() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("group1", "111", "222"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().groupDeletion();
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size() - 1, after.size());

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        }



}
