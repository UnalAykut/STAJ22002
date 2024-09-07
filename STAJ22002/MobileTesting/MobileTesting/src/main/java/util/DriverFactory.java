package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static AppiumDriver driver;
    private static Properties properties;

    public static AppiumDriver initializeDriver(String platform, String udid, String appPackage, String appActivity) throws MalformedURLException {
        if (driver == null) {
            properties = ConfigReader.getProperties();
            DesiredCapabilities capabilities = new DesiredCapabilities();

            setCommonCapabilities(capabilities, platform, udid);

            if (platform.equalsIgnoreCase("Android")) {
                capabilities.setCapability("appPackage", appPackage);
                capabilities.setCapability("appActivity", appActivity);
            }

            driver = new AppiumDriver(new URL(properties.getProperty("appiumServerURL")), capabilities);
            int impWait = Integer.parseInt(properties.getProperty("implicitWait"));
            driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        }
        return getDriver();
    }

    private static void setCommonCapabilities(DesiredCapabilities capabilities, String platform, String udid) {
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("udid", udid);
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
