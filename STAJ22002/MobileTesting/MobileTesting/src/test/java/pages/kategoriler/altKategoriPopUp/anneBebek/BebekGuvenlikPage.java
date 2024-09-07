package pages.kategoriler.altKategoriPopUp.anneBebek;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class BebekGuvenlikPage extends AbstractCategoryPage<BebekGuvenlikPage.Kategori> {
    public BebekGuvenlikPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        BEBEK_TELSIZI_KAMERA("Bebek Telsizi & Kamera"),
        EV_GUVENLIK_URUNLERI("Ev Güvenlik Ürünleri"),
        KILIT_KOSE_KORUYUCU("Kilit & Köşe Koruyucusu"),
        OTO_GUVENLIK_URUNLERI("Oto Güvenlik Ürünleri"),
        PRIZ_EMNIYETI("Priz Emniyeti"),
        YATAK_BARIYERI("Yatak Bariyeri");

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
