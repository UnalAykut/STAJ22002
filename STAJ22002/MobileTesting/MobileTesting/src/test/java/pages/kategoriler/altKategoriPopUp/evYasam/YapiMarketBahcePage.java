package pages.kategoriler.altKategoriPopUp.evYasam;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class YapiMarketBahcePage extends AbstractCategoryPage<YapiMarketBahcePage.Kategori> {
    public YapiMarketBahcePage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        ELEKTRIKLI_ALETLER("Elektrikli Aletler"),
        EL_ALETLERI("El Aletleri"),
        MATKAPLAR("Matkaplar"),
        BAHCE_MAKINELERI("Bahçe Makineleri"),
        ELEKTRIK_AYDINLATMA("Elektrik & Aydınlatma"),
        BAHCE_CICEK("Bahçe & Çiçek"),
        BAHCE_SULAMA("Bahçe Sulama"),
        BOYA_BOYA_MALZEMELERI("Boya & Boya Malzemeleri"),
        MANGAL_BARBEKU("Mangal & Barbekü"),
        NALBURYE_HIRDAVAT("Nalburye & Hırdavat"),
        AKILLI_EV_SISTEMLERI("Akıllı Ev Sistemleri"),
        GUNES_VE_RUZGAR_ENERJISI("Güneş ve Rüzgar Enerjisi"),
        HAVUZ_EKIPMANLARI("Havuz & Ekipmanları"),
        HAYVANCILIK_EKIPMANLARI("Hayvancılık Ekipmanları"),
        ISITMA_VE_SOĞUTMA("Isıtma ve Soğutma"),
        IS_GUVENLIGI("İş Sağlığı ve Güvenliği"),
        KAYNAK_VE_LEHIMLEME("Kaynak ve Lehimleme"),
        MAKINE_PARCALARI("Makine Parçaları ve Aksesuarları"),
        YAPI_MALZEMELERI("Yapı Malzemeleri");

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
