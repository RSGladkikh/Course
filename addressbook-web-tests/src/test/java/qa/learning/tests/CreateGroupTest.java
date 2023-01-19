package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.GroupData;


public class CreateGroupTest extends TestBase {

  @Test
  public void createGroup() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("group1", "check", "that"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupPage();
  }

}
