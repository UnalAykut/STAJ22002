package pages.kategoriler.altKategoriPopUp.evYasam;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.BasePage;
import pages.DisplayNameEnum;

import java.util.List;

public class MutfakGerecleriPage extends AbstractCategoryPage<MutfakGerecleriPage.Kategori> {
    public MutfakGerecleriPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        YEMEK_PISIRME("Yemek Pişirme"),
        SOFRA("Sofra"),
        PRATIK_MUTFAK_GERECLERI("Pratik Mutfak Gereçleri"),
        SAKLAMA_KAPLAN_DUZENLEME("Saklama Kaplan & Düzenleme"),
        CAY_KAHVE_DEMLEME("Çay & Kahve Demleme"),
        CESITLI_SETLER("Çeşitli Setler"),
        ENDÜSTRIYEL_MUTFAK_EKIPMANLARI("Endüstriyel Mutfak Ekipmanları"),
        TEPSILER_URUNLER("Tepsiler & Ürünler");

        private final String displayName;

        Kategori(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }
    }

    public void loadCategories() {
        kategoriMap = loadCategories(kategoriElements, categoryTextXPath,Kategori.class);
    }

    public void clickOnCategory(Kategori kategori) {
        BasePage.clickOnCategory(kategoriMap, kategori, categoryTextXPath);
    }

    public List<WebElement> categoryList(){
        return getCategoryElements(kategoriElements);
    }

    @Override
    protected Class<Kategori> getCategoryEnumClass() {
        return Kategori.class;
    }
}
