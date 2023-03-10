package qa.learning.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.learning.model.GroupData;
import qa.learning.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class EditGroupTest extends TestBase{

    @BeforeTest
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("group1").withHeader("111").withFooter("222"));
        }
    }


    @Test
    public void testEditGroupTest() {

        Groups before = app.group().all();
        GroupData editedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(editedGroup.getId()).withName("group1Edited").withHeader("222").withFooter("333");
        app.group().edit(group);
        assertThat(before.size(),equalTo(app.group().count()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withEdited(editedGroup, group)));




    }


}
