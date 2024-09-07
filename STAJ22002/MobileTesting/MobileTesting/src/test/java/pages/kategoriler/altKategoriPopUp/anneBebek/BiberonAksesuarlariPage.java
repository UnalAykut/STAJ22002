package pages.kategoriler.altKategoriPopUp.anneBebek;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.BasePage;
import pages.DisplayNameEnum;

import java.util.List;

public class BiberonAksesuarlariPage extends AbstractCategoryPage<BiberonAksesuarlariPage.Kategori> {
    public BiberonAksesuarlariPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        MAMA_ONLUKLERI_AKSESUAR("Mama Önlükleri & Aksesuarlar"),
        BIBERON("Biberon"),
        BIBERON_ISITICILARI("Biberon Isıtıcıları"),
        DIS_KAŞIYICI_CINGIRAK("Diş Kaşıyıcı & Çıngırak"),
        TERMOS_ALISTIRMA_BARDAK("Termos ve Alıştırma Bardakları");

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

    public void clickOnCategory(BiberonAksesuarlariPage.Kategori kategori) {
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
