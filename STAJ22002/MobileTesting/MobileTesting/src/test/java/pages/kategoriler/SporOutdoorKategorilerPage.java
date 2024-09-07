package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class SporOutdoorKategorilerPage extends AbstractCategoryPage {
    public SporOutdoorKategorilerPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        FITNESS_KONDISYON("Fitness & Kondisyon"),
        SPOR_GIYIM_AYAKKABI("Spor Giyim & Ayakkabı"),
        OUTDOOR_KAMP("Outdoor & Kamp"),
        BIREYSEL_TAKIM_SPORLARI("Bireysel & Takım Sporları"),
        AVCILIK_BALIKCILIK("Avcılık & Balıkçılık"),
        KIS_SPORLARI("Kış Sporları"),
        BISIKLET_SCOOTER("Bisiklet & Scooter"),
        TEKNE_YAT_MALZEMELERI("Tekne & Yat Malzemeleri"),
        SU_SPORLARI("Su Sporları");

        private String displayName;

        Kategori(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }
    }
    @Override
    protected Class getCategoryEnumClass() {
        return null;
    }
}
