package qa.learning.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.Browser;
import qa.learning.appmanager.ApplicationManager;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(Browser.CHROME);

    @Before
    public void setUp() {
        app.init();
    }

    @After
    public void tearDown() {
        app.stop();
    }





}
