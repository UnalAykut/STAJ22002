package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class MucevherSaatKategorilerPage extends AbstractCategoryPage {
    public MucevherSaatKategorilerPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        YATIRIMLIK_ALTIN_GUMUS("Yatırımlık Altın & Gümüş"),
        SAAT("Saat"),
        GUNES_GOZLUGU("Güneş Gözlüğü"),
        ALTIN_TAKILAR("Altın Takılar"),
        PIRLANTA_TAKILAR("Pırlanta Takılar"),
        GUMUS_TAKILAR("Gümüş Takılar"),
        CELIK_TAKILAR("Çelik Takılar"),
        BIJUTERI_TAKILAR("Bijuteri Takılar"),
        AKSESUAR("Aksesuar"),
        TAKI_AKSESUARLAR("Takı Aksesuarlar"),
        IKINCI_EL_ANTIKA_KOLEKSIYON("2. El Antika & Koleksiyon");

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
