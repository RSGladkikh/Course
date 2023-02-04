package qa.learning.tests;

import org.junit.Test;
import qa.learning.model.GroupData;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class DeleteGroupTest extends TestBase {

    @Test
    public void testDeleteGroupTest() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("group1").withHeader("111").withFooter("222"));
        }
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        assertThat(after.size(), equalTo(before.size() - 1));

        before.remove(deletedGroup);
        assertThat(after, equalTo(before));
        }


    }



