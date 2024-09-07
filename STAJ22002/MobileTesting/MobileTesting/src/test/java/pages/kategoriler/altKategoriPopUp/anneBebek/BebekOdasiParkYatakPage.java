package pages.kategoriler.altKategoriPopUp.anneBebek;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class BebekOdasiParkYatakPage extends AbstractCategoryPage<BebekOdasiParkYatakPage.Kategori> {
    public BebekOdasiParkYatakPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        BEBEK_ODASI_DEKORASYON("Bebek Odası Dekorasyon"),
        BEBEK_ODASI_TEKSTIL("Bebek Odası Tekstil"),
        BEBEK_ODASI_MOBILYA("Bebek Odası Mobilya"),
        BEBEK_PARK_YATAK_SALINCAK("Beşik, Park Yatak, Salıncak");

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
