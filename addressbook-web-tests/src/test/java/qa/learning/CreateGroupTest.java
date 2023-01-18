package qa.learning;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class CreateGroupTest extends TestBase {

  @Test
  public void createGroup() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("group1", "check", "that"));
    submitGroupCreation();
    gotoGroupPage();
  }

}
