package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.GroupData;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class CreateGroupTest extends TestBase {

  @Test
  public void createGroup() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("group1", "check", "that"));
    app.submitGroupCreation();
    app.gotoGroupPage();
  }

}
