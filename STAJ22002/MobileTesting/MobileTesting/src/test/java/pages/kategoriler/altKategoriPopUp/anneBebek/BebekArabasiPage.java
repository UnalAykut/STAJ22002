package pages.kategoriler.altKategoriPopUp.anneBebek;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class BebekArabasiPage extends AbstractCategoryPage<BebekArabasiPage.Kategori> {
    public BebekArabasiPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        UCH_TEKERLEKLI_BEBEK_ARABASI("3 Tekerlekli Bebek Arabası"),
        BASTON_PUSETER("Baston Pusetler"),
        BEBEK_ARABASI_AKSESUAR("Bebek Arabası Aksesuar"),
        CIFT_YONU_BEBEK_ARABASI("Çift Yönlü Bebek Arabası"),
        IKIZ_BEBEK_ARABASI("İkiz Bebek Arabası"),
        TEK_YONU_BEBEK_ARABASI("Tek Yönlü Bebek Arabası"),
        TRAVEL_SISTEM_BEBEK_ARABASI("Travel Sistem Bebek Arabası"),
        PORTBEBE("Portbebe");

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
