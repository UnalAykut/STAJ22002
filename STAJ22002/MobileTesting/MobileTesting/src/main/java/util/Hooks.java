package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Reporter;

import java.io.IOException;
import java.util.Properties;

public class Hooks {
    private AppiumDriver driver;
    private final Properties properties = ConfigReader.getProperties();

    @Before
    public void setUp() throws IOException {
        String platform = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platform");
        String udid = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("udid");
        String appPackage = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("appPackage");
        String appActivity = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("appActivity");

        driver = DriverFactory.initializeDriver(platform, udid, appPackage, appActivity);
    }

    @After
    public void quitDriver() {
        DriverFactory.quitDriver();
    }
}
