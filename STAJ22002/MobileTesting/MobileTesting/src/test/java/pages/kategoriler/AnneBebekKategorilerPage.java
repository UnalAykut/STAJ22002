package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class AnneBebekKategorilerPage extends AbstractCategoryPage {
    public AnneBebekKategorilerPage(AppiumDriver driver) {
        super( driver );
    }
    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        BEBEK_BEZI_ISLAK_MENDIL("Bebek Bezi & Islak Mendil"),
        BEBEK_GIYIM("Bebek Giyim"),
        HAMILE_GIYIM("Hamile Giyim"),
        BEBEK_ARABALARI("Bebek Arabaları"),
        OTO_KOLTUGU_ANA_KUCAGI("Oto Koltuğu & Ana Kucağı"),
        BESLENME_MAMA_SANDALYESI("Beslenme & Mama Sandalyesi"),
        BIBERON_AKSESUARLARI("Biberon ve Aksesuarları"),
        EMZIRME_URUNLERI("Emzirme Ürünleri"),
        YURUTEC_YURUME_YARDIMCILARI("Yürüteç, Yürüme Yardımcıları"),
        BEBEK_ODASI_PARK_YATAK("Bebek Odası & Park Yatak"),
        BEBEK_BAKIM_SAGLIK("Bebek Bakım & Sağlık"),
        BEBEK_GUVENLIK("Bebek Güvenlik"),
        BEBEK_OYUNCAKLARI("Bebek Oyuncakları"),
        BANYO_TUVALET("Banyo & Tuvalet");

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
