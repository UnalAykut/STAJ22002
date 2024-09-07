package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AbstractCategoryPage<T extends Enum<T> & DisplayNameEnum> extends BasePage implements PageActions<T> {

    @FindBy(xpath = "//android.view.ViewGroup[android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'] and android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']]")
    private List<WebElement> kategoriElements;

    public AbstractCategoryPage(AppiumDriver driver) {
        super(driver);
    }

    public void loadCategories() {
        kategoriMap = loadCategories(kategoriElements, categoryTextXPath, getCategoryEnumClass());
    }

    public void clickOnCategory(T kategori) {
        BasePage.clickOnCategory(kategoriMap, kategori, categoryTextXPath);
    }

    public List<WebElement> categoryList() {
        return getCategoryElements(kategoriElements);
    }

    protected abstract Class<T> getCategoryEnumClass();
}

