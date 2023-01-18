package qa.learning.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import qa.learning.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() {
        app.init();
    }

    @After
    public void tearDown() {
      app.driver.findElement(By.linkText("Logout")).click();
      app.stop();
    }

}
