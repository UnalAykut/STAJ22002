package pages.kategoriler.altKategoriPopUp.elektronik;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElektrikliEvAletleriPage extends AbstractCategoryPage<ElektrikliEvAletleriPage.Kategori> {
    private Map<String, WebElement> kategoriMap = new HashMap<>();
    private String categoryTextXPath = ".//android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']";
    public ElektrikliEvAletleriPage(AppiumDriver driver) {
        super( driver );
    }
    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        ELEKTRIKLI_MUTFAK_ALETLERI("Elektrikli Mutfak Aletleri"),
        UTU("Ütü"),
        DIKIS_MAKINESI_VE_AKSESUARLARI("Dikiş Makinesi ve Aksesuarları"),
        ELEKTRIKLI_SUPURGE_YIKAMA("Elektrikli Süpürge & Yıkama"),
        TESHIR_OUTLET_URUNLERI("Teşhir & Outlet Ürünleri");

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
        return Kategori.class;
    }
}
