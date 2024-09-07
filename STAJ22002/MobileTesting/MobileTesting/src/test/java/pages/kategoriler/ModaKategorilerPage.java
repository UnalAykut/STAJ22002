package pages.kategoriler;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

import java.util.List;

public class ModaKategorilerPage extends AbstractCategoryPage {
    public ModaKategorilerPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public enum Kategori implements DisplayNameEnum {
        AYAKKABI_CANTA("Ayakkabı & Çanta"),
        KADIN_GIYIM_AKSESUAR("Kadın Giyim & Aksesuar"),
        ERKEK_GIYIM_AKSESUAR("Erkek Giyim & Aksesuar"),
        COCUK_GIYIM_AKSESUAR("Çocuk Giyim & Aksesuar");

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
