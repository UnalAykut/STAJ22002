package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.KozmetikKategorilerPage;
import test.baseTest.BaseTest;

public class KozmetikKategorilerPageTest extends BaseTest {
    private KozmetikKategorilerPage kozmetikKategorilerPage;

    @Override
    public void intializePages() {
        super.intializePages();
        kozmetikKategorilerPage = new KozmetikKategorilerPage(driver);
    }

    @Test
    public void kozmetikKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(KategorilerPage.Kategori.KOZMETIK);
        Thread.sleep(2000);
        kozmetikKategorilerPage.loadCategories();
        kozmetikKategorilerPage.clickOnCategory(KozmetikKategorilerPage.Kategori.PARFUM_DEODORANT);
        Thread.sleep(2000);
    }
}
