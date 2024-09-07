package pages.kategoriler.altKategoriPopUp.anneBebek;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class BebekBeziIslakMendilPage extends AbstractCategoryPage<BebekBeziIslakMendilPage.Kategori> {
    public BebekBeziIslakMendilPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        ALT_ACMA_PEDI_MINDERI("Alt Açma Pedi & Minderi"),
        BEBEK_BEZI("Bebek Bezi"),
        ISLAK_MENDIL_HAVLU("Islak Mendil & Havlu");

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

