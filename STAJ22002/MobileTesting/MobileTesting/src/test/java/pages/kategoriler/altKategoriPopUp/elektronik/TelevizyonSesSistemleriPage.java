package pages.kategoriler.altKategoriPopUp.elektronik;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class TelevizyonSesSistemleriPage extends AbstractCategoryPage<TelevizyonSesSistemleriPage.Kategori> {

    public TelevizyonSesSistemleriPage(AppiumDriver driver) {
        super( driver );
    }
    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        DVD_BLU_RAY_MEDYA_OYNATICI("DVD, Blu-Ray, Medya Oynatıcılar"),
        MP3_MP4_CALAR_AKSESUARLARI("MP3, MP4 Çalar & Aksesuarları"),
        MUZIK_SISTEMLERI("Müzik Sistemleri"),
        PIL("Pil"),
        SES_SISTEMLERI("Ses Sistemleri"),
        TELEVIZYON("Televizyon"),
        TELEVIZYON_AKSESUARLARI("Televizyon Aksesuarları"),
        UYDU_SISTEMLERI("Uydu Sistemleri"),
        BLUETOOTH_HOPARLORLER("Bluetooth Hoparlörler"),
        IKINCI_EL_TESHIR_CIHAZLARI("İkinci El & Teşhir Cihazları"),
        PROJEKSIYON_AKSESUARLARI("Projeksiyon ve Aksesuarları");

        private final String displayName;

        Kategori(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    @Override
    protected Class<Kategori> getCategoryEnumClass() {
        return null;
    }


}
