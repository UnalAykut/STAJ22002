package pages.kategoriler.altKategoriPopUp.anneBebek;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

;

public class BanyoTuvaletPage extends  AbstractCategoryPage<BanyoTuvaletPage.Kategori> {
    public BanyoTuvaletPage(AppiumDriver driver) {
        super( driver );
    }

    @Override
    protected Class<Kategori> getCategoryEnumClass() {
        return Kategori.class;
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        BANYO_GERECLERI_VE_AKSESUARLAR( "Banyo Gereçleri ve Aksesuarlar" ),
        BANYO_SUNGERI_KESE( "Banyo Süngeri & Kese" ),
        HAVLU_BORNOZ( "Havlu & Bornoz" ),
        KUVET_URUNLERI( "Küvet Ürünleri" ),
        MAPRAGA_KOVA( "Maşrapa & Kova" ),
        SABUN( "Sabun" ),
        SAMPUAN_KREM( "Şampuan & Krem" ),
        TUVALET_EGITIMI( "Tuvalet Eğitimi" );

        private final String displayName;

        Kategori(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }
    }


}