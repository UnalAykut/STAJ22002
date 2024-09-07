package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class N11Pages extends BasePage{
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Kategoriler\"]/android.widget.FrameLayout/android.widget.ImageView\n")
    private WebElement kategoriButton;
    @FindBy(xpath = "//*[@resource-id='com.dmall.mfandroid:id/listingFilterRL']")
    private WebElement filtreleButton;
    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.dmall.mfandroid:id/giybiFilterShowResultsBTN']")
    private WebElement sonuclariGosterButton;

    public N11Pages(AppiumDriver driver) {
        super( driver );
    }

    public void clickKategoriler() {
        elementHelper.clickElement( kategoriButton );
    }
    public void clickFiltrele() {
        elementHelper.clickElement( filtreleButton );
    }
    public void clickFiltreleSonucGoster(){
        elementHelper.clickElement( sonuclariGosterButton );
    }

}
