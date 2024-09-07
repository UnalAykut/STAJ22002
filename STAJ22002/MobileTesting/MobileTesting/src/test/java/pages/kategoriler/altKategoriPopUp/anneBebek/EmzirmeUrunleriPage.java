package pages.kategoriler.altKategoriPopUp.anneBebek;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class EmzirmeUrunleriPage extends AbstractCategoryPage<EmzirmeUrunleriPage.Kategori> {
    public EmzirmeUrunleriPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        EMZIRME_SUTYENI("Emzirme Sütyeni"),
        EMZIRME_YASTIGI_ORTUSU("Emzirme Yastığı & Örtüsü"),
        GOGUS_KREMI("Göğüs Kremi"),
        GOGUS_PEDLERI_KORUYUCULAR("Göğüs Pedleri & Koruyucular"),
        GOGUS_POMPALARI("Göğüs Pompaları"),
        SUT_SAKLAMA_POSET_KAPLAR("Süt Saklama Poşet & Kapları"),
        ANNE_ICECEKLERI("Anne İçecekleri");

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
