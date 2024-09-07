package pages.kategoriler.altKategoriPopUp.anneBebek;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class BebekOyuncaklariPage extends AbstractCategoryPage<BebekOyuncaklariPage.Kategori> {
    public BebekOyuncaklariPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        O_6_AY_OYUNCAK("0-6 Ay Oyuncak"),
        BIR_UC_YAS_OYUNCAK("1-3 Yaş Oyuncak"),
        ALTI_ON_IKI_AY_OYUNCAK("6-12 Ay Oyuncak"),
        CINGIRAK("Cıngırak"),
        BANYO_OYUNCAKLARI("Banyo Oyuncakları");

        private final String displayName;

        Kategori(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }
    }

    @Override
    protected Class<Kategori> getCategoryEnumClass() {
        return Kategori.class;
    }
}
