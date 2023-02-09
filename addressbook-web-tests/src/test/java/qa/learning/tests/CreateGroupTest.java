package qa.learning.tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import qa.learning.model.GroupData;
import qa.learning.model.Groups;

import java.util.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(value = Parameterized.class)
public class CreateGroupTest extends TestBase {

    public GroupData group;

    public CreateGroupTest(GroupData group) {
        this.group = group;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> validGroups() {
      GroupData[][] validGroups = new GroupData[][]{ {new GroupData().withName("group 1").withHeader("header 1").withFooter("footer 1")},
      {new GroupData().withName("group 2'").withHeader("header 2").withFooter("footer 2")},
      {new GroupData().withName("group 3").withHeader("header 3").withFooter("footer 3")}
      };
      return Arrays.asList(validGroups);


    }




    @Test
    public void testCreateGroup() {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(before.size() + 1, equalTo(app.group().count()));
      Groups after = app.group().all();
      before.add(group);
      assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

  }
