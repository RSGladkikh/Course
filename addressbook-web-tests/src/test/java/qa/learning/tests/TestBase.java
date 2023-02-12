package qa.learning.tests;


import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import qa.learning.appmanager.ApplicationManager;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app = new ApplicationManager(Browser.CHROME);

    @BeforeSuite
    public static void setUp() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Start test " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
        public void logTestStop (Method m){
            logger.info("Stop test " + m.getName());
        }






}
