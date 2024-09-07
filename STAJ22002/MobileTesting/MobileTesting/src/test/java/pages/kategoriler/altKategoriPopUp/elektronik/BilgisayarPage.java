package pages.kategoriler.altKategoriPopUp.elektronik;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class BilgisayarPage extends AbstractCategoryPage<BilgisayarPage.Kategori> {

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public BilgisayarPage(AppiumDriver driver) {
        super( driver );
    }
    public enum Kategori implements DisplayNameEnum {
        TABLET("Tablet"),
        DIZUSTU_BILGISAYAR("Dizüstü Bilgisayar"),
        MASAUSTU_BILGISAYAR("Masaüstü Bilgisayar"),
        SUNUCU_VE_AKSESUARLARI("Sunucu ve Aksesuarları"),
        YEDEKLEME_URUNLERI("Yedekleme Ürünleri"),
        MODEM_VE_AG_URUNLERI("Modem & Ağ Ürünleri"),
        CEVRE_BIRIMLERI("Çevre Birimleri"),
        BILGISAYAR_BILESENLERI("Bilgisayar Bileşenleri"),
        YAZICI_TARAYICI_AKSESUARLARI("Yazıcı, Tarayıcı ve Aksesuarları"),
        E_KITAP_OKUYUCU("E-Kitap Okuyucu ve Aksesuarları"),
        AKSESUAR_VE_YEDEK_PARCA("Aksesuar & Yedek Parça"),
        OFIS_ELEKTRONIGI("Ofis Elektroniği"),
        OYUN_VE_YAZILIM("Oyun & Yazılım"),
        YENILENMIS_ILK_KEZ_TEHSIR_URUNLERI("Yenilenmiş İkinci El & Teşhir Ürünleri");

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
