package qa.learning.tests;


import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import qa.learning.appmanager.ApplicationManager;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(Browser.CHROME);

    @BeforeSuite
    public static void setUp() {
        app.init();
    }

    @AfterSuite
    public static void tearDown() {
        app.stop();
    }





}
