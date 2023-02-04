package qa.learning.tests;


import org.junit.Assert;
import org.junit.Test;
import qa.learning.model.GroupData;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class EditGroupTest extends TestBase{


    @Test
    public void testEditGroupTest() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("group1").withHeader("111").withFooter("222"));
        };
        Set<GroupData> before = app.group().all();
        GroupData editedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(editedGroup.getId()).withName("group1Edited").withHeader("222").withFooter("333");
        app.group().edit(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(editedGroup);
        before.add(group);
        assertThat(after, equalTo(before));




    }


}
