package pages.kategoriler.altKategoriPopUp.evYasam;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class KirtasiyeOfisPage extends AbstractCategoryPage<KirtasiyeOfisPage.Kategori> {
    public KirtasiyeOfisPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        OFIS_MALZEMELERI("Ofis Malzemeleri"),
        OFIS_KIRTASIYE("Ofis Kırtasiye"),
        OKUL_CANTALARI("Okul Çantaları"),
        OKUL_KIRTASIYESI("Okul Kırtasiyesi"),
        KAGIT_URUNLERI("Kağıt Ürünleri"),
        KALEM_VE_YAZI_GERECLERI("Kalem ve Yazı Gereçleri"),
        DOSYALAMA_ARSIVLEME("Dosyalama & Arşivleme"),
        DEFTER_AJANDA("Defter & Ajanda"),
        YAZI_TAHTASI_AKSESUARLARI("Yazı Tahtası ve Aksesuarları"),
        PANO_AKSESUARLARI("Pano ve Aksesuarları"),
        SANATSAL_MALZEMELER("Sanatsal Malzemeler");

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
