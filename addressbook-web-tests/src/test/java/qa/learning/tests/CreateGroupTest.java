package qa.learning.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.learning.model.GroupData;
import qa.learning.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class CreateGroupTest extends TestBase {

   @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(("src/test/java/qa/learning/resources/groups.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(GroupData.class);
            List<GroupData> groups = (List<GroupData>)xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }

    }
    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/qa/learning/resources/groups.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
            }.getType());
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validGroupsFromXml")
    public void testCreateGroup(GroupData group) {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(before.size() + 1, equalTo(app.group().count()));
      Groups after = app.group().all();
      before.add(group);
      assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

  }
