package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.DisplayNameEnum;

import java.util.List;

public class KategorilerPage extends BasePage {
    public KategorilerPage(AppiumDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;
    public enum Kategori implements DisplayNameEnum {
        MODA("Moda"),
        ELEKTRONIK("Elektronik"),
        EV_YASAM("Ev & Yaşam"),
        ANNE_BEBEK("Anne & Bebek"),
        KOZMETIK("Kozmetik & Kişisel Bakım"),
        MUCEVHER_SAAT("Mücevher & Saat"),
        SPOR_OUTDOOR("Spor & Outdoor"),
        KITAP_MUZIK_FILM_OYUN("Kitap, Müzik, Film ,Oyun"),
        OTOMOTIV_MOTOSIKLET("Otomotiv & Motosiklet"),
        YURT_DISINDAN_URUNLER("Yurt Dışından Ürünler"),
        PET11("pet11");

        private String displayName;

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


   /* public List<WebElement> getCategoryElements() {
        return kategoriElements;
    }*/
   /* public void selectCategory(KategorilerPage.Kategori kategori) {
        clickOnCategory(kategoriler, kategori.getDisplayName());
    }*/



}