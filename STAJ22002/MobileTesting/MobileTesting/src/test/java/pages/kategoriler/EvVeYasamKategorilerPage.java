package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class EvVeYasamKategorilerPage extends AbstractCategoryPage {
    public EvVeYasamKategorilerPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        MOBILYA("Mobilya"),
        DEKORASYON_AYDINLATMA("Dekorasyon & Aydınlatma"),
        EV_TEKSTILI("Ev Tekstili"),
        MUTFAK_GERECLERI("Mutfak Gereçleri"),
        BANYO_EV_GERECLERI("Banyo & Ev Gereçleri"),
        YAPI_MARKET_BAHCE("Yapı Market & Bahçe"),
        EVCIL_HAYVAN_URUNLERI("Evcil Hayvan Ürünleri"),
        KIRTASIYE_OFIS("Kırtasiye & Ofis"),
        SUPERMARKET("Süpermarket");

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
