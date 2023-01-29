package qa.learning.tests;

import org.junit.Assert;
import org.junit.Test;
import qa.learning.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class EditGroupTest extends TestBase{

    @Test
    public void testEditGroupTest() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("group1", "111", "222"));
        };
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupEdit();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(), "group1Edited", "222", "333");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupEdit();
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(group);

        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
