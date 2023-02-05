package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.learning.model.GroupData;
import qa.learning.model.Groups;



import java.util.List;


public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.name());
        type(By.name("group_header"), groupData.header());
        type(By.name("group_footer"), groupData.footer());
    }

    public void submitCreation() {
        click(By.name("submit"));
    }

    public void initCreation() {
        click(By.name("new"));
    }

    public void selectByIndex(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }
    public void selectById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void initEdit() {
        click(By.name("edit"));
    }

    public void submitEdit() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initCreation();
        fillGroupForm(group);
        submitCreation();
        groupCache = null;
        returnToGroupPage();
    }

    private void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public boolean isThereAGroup() {
        return (isElementPresent(By.name("selected[]")));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void delete(GroupData group) {
        selectById(group.getId());
        deleteSelectedGroup();
        groupCache = null;
        returnToGroupPage();
    }

    public void edit(GroupData group) {
        selectById(group.getId());
        initEdit();
        fillGroupForm(group);
        submitEdit();
        groupCache = null;
        returnToGroupPage();
    }


    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        Groups groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }
}

