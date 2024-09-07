package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {

    private final AppiumDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    @FindBy(id = "com.dmall.mfandroid:id/ivSearchBarBack")
    private WebElement searchPressBack;
    public void searchBackButton() {
        waitForVisibility(searchPressBack);
        searchPressBack.click();
    }
    @FindBy(id="com.dmall.mfandroid:id/ivBackToolbar")
    private WebElement pressBack;
    public void clickBackButton() {
        waitForVisibility(pressBack);
        pressBack.click();
    }
    public ElementHelper(AppiumDriver driver) {
        this.driver = driver;
        int timeout = Integer.parseInt(ConfigReader.getProperties().getProperty("elementWaitTimeout", "10"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        this.actions = new Actions(driver);
        PageFactory.initElements( driver,this );
    }

    public void clickElement(WebElement element) {
        waitForVisibility(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean isElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickability(WebElement element) {

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
