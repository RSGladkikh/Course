package qa.learning.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.learning.model.GroupData;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.name());
        type(By.name("group_header"), groupData.header());
        type(By.name("group_footer"), groupData.footer());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void groupDeletion() {
        click(By.name("delete"));
    }

    public void initGroupEdit() {
        click(By.name("edit"));
    }

    public void submitGroupEdit() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    private void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public boolean isThereAGroup() {
        return (isElementPresent(By.name("selected[]")));
    }
}

