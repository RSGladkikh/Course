package qa.learning.tests;

import org.junit.Before;
import org.junit.Test;
import qa.learning.model.GroupData;
import qa.learning.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class DeleteGroupTest extends TestBase {

    @Before
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("group1").withHeader("111").withFooter("222"));
        }
    }

    @Test
    public void testDeleteGroupTest() {

        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withoutDeleted(deletedGroup)));
        }


    }



