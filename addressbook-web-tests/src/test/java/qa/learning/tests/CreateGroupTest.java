package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.GroupData;


public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("group1", "111", "222"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupPage();
  }

}
