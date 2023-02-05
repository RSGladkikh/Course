package qa.learning.tests;


import org.junit.Test;
import qa.learning.model.GroupData;
import qa.learning.model.Groups;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Group2").withFooter("876").withHeader("666");
    app.group().create(group);
    assertThat(before.size() + 1, equalTo(app.group().count()));
    Groups after = app.group().all();
    before.add(group);
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
