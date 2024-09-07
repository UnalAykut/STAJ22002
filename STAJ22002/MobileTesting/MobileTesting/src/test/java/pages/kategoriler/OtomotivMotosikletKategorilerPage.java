package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class OtomotivMotosikletKategorilerPage extends AbstractCategoryPage {
    public OtomotivMotosikletKategorilerPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        AKSESUAR_TUNING("Aksesuar & Tuning"),
        YEDEK_PARCA("Yedek Parça"),
        SES_SISTEMLERI_NAVIGASYON("Ses Sistemleri & Navigasyon"),
        LASTIK_JANT("Lastik & Jant"),
        MOTOSIKLET("Motosiklet"),
        TREKTOR("Traktör");

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
        return Kategori.class;
    }
}
