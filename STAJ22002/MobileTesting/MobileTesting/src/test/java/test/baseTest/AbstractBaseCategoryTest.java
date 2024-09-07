package test.baseTest;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;
import pages.N11Pages;
import pages.kategoriler.KategorilerPage;

public abstract class AbstractBaseCategoryTest extends BaseTest {
    protected KategorilerPage kategorilerPage;
    protected N11Pages n11Pages;

    @BeforeClass
    @Override
    public void intializePages() {
        super.intializePages();
        n11Pages = new N11Pages(driver);
        kategorilerPage = new KategorilerPage(driver);
    }

    // AbstractCategoryPage üzerinden sayfa oluşturma
    protected <T extends AbstractCategoryPage<?>> T createCategoryPage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(AppiumDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Page creation failed: " + e.getMessage(), e);
        }
    }

    // Kategori testini gerçekleştiren metod
    protected <T1 extends Enum<T1> & DisplayNameEnum, T2 extends Enum<T2> & DisplayNameEnum> void performCategoryTest(
            KategorilerPage.Kategori mainCategory, // Ana kategori: KategorilerPage.Kategori.ANNE_BEBEK
            Class<? extends AbstractCategoryPage>subCategoryClass, // Alt kategori sayfa sınıfı: AnneBebekKategorilerPage.class
            T1 subCategoryEnum, // Alt kategori enum değeri: AnneBebekKategorilerPage.Kategori.BANYO_TUVALET
            Class<?extends AbstractCategoryPage> detailClass // Detay sayfa sınıfı: BanyoTuvaletPage.class
    ) throws InterruptedException {
        // Ana kategoriye tıklama
        n11Pages.clickKategoriler();
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(mainCategory);

        // Alt ve detay sayfalarının dinamik olarak oluşturulması
        AbstractCategoryPage<T1> subCategoryPage = createCategoryPage(subCategoryClass);
        AbstractCategoryPage<T2> detailPage = createCategoryPage(detailClass);

        // Alt kategoriye tıklama
        subCategoryPage.loadCategories();
        subCategoryPage.clickOnCategory(subCategoryEnum);

        // Kategorilerde gezinme ve doğrulama
        detailPage.gezAndValidateCategories(subCategoryPage, detailPage,subCategoryEnum );
    }
}
