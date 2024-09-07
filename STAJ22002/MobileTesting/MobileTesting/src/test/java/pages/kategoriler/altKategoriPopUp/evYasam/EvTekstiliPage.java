package pages.kategoriler.altKategoriPopUp.evYasam;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class EvTekstiliPage extends AbstractCategoryPage<EvTekstiliPage.Kategori> {
    public EvTekstiliPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        YATAK_ODASI_TEKSTILI("Yatak Odası Tekstili"),
        HALI_KILIM("Halı & Kilim"),
        PERDE_VE_AKSESUARLARI("Perde ve Aksesuarları"),
        BANYO_TEKSTILI("Banyo Tekstili"),
        MUTFAK_TEKSTILI("Mutfak Tekstili"),
        SALON_TEKSTILI("Salon Tekstili");

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
