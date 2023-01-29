package qa.learning.tests;

import org.junit.Assert;
import org.junit.Test;
import qa.learning.model.GroupData;


import java.util.Comparator;
import java.util.List;




public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData("group2", "112", "222");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size() + 1, after.size());

    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(groupData -> groupData.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
