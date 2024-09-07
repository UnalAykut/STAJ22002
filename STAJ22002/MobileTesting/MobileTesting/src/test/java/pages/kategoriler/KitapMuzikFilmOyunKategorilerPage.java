package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class KitapMuzikFilmOyunKategorilerPage extends AbstractCategoryPage {
    public KitapMuzikFilmOyunKategorilerPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        KITAP("Kitap"),
        FILM("Film"),
        MUZIK("Müzik"),
        COCUK_OYUNCAKLARI("Çocuk Oyuncakları"),
        YETISKIN_HOBI_OYUN("Yetişkin Hobi & Oyun"),
        DIJITAL_KODLAR_URUNLER("Dijital Kodlar & Ürünler"),
        DUGUN_DAVET_ORGANIZASYON("Düğün, Davet, Organizasyon"),
        EL_ISI_URUNLERI("El İşi Ürünleri"),
        YASAM_ETKINLIK("Yaşam ve Etkinlik");

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
