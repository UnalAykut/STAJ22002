package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class KozmetikKategorilerPage extends AbstractCategoryPage {
    public KozmetikKategorilerPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        PARFUM_DEODORANT("Parfüm & Deodorant"),
        SAC_BAKIM_SEKILLENDIRME("Saç Bakım & Şekillendirme"),
        CILT_BAKIMI("Cilt Bakımı"),
        MAKYAJ("Makyaj"),
        SAGLIK_MEDIKAL_URUNLER("Sağlık & Medikal Ürünler"),
        KADIN_BAKIM_URUNLERI("Kadın Bakım Ürünleri"),
        ERKEK_BAKIM_URUNLERI("Erkek Bakım Ürünleri"),
        GUZELLIK_SALONU_KUAFOR("Güzellik Salonu & Kuaför"),
        AGIZ_DIS_BAKIM("Ağız & Diş Bakım"),
        CINSEL_URUNLER("Cinsel Ürünler"),
        EV_KOZMETIGI("Ev Kozmetiği");

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
