package pages.kategoriler.altKategoriPopUp.evYasam;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.BasePage;
import pages.DisplayNameEnum;

import java.util.List;

public class MobilyaPage extends AbstractCategoryPage<MobilyaPage.Kategori> {
    public MobilyaPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        ANTRE("Antre"),
        BANYO_MOBILYASI("Banyo Mobilyası"),
        COCUK_GENÇ_ODASI("Çocuk & Genç Odası"),
        GARDROP("Gardrop"),
        KARYOLA_YATAK_BAZA("Karyola, Yatak, Baza"),
        KITAPLIK_RAF("Kitaplık & Raf"),
        KOMODIN_SIFONYER("Komodin & Şifonyer"),
        MASALAR("Masalar"),
        MUTFAK_MOBILYASI("Mutfak Mobilyası"),
        OFIS_MOBILYASI("Ofis Mobilyası"),
        OTURMA_GRUPLARI("Oturma Grupları"),
        SANDALYELER("Sandalye"),
        SEHPA("Sehpa"),
        TV_UNITESI_TV_SEHPASI("TV Ünitesi & TV Sehpası"),
        YATAK_ODASI("Yatak Odası"),
        YEMEK_ODASI("Yemek Odası"),
        BAHCE_MOBILYASI("Bahçe Mobilyası"),
        MOBILYA_AKSESUARLARI("Mobilya Aksesuarları"),
        NAKLIYE_MONTALJ("Nakliye & Montaj");

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
