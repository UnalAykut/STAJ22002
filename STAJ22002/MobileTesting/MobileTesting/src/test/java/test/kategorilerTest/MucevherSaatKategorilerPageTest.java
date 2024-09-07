package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.MucevherSaatKategorilerPage;
import test.baseTest.BaseTest;

public class MucevherSaatKategorilerPageTest extends BaseTest {
    private MucevherSaatKategorilerPage mucevherSaatKategorilerPage;

    @Override
    public void intializePages() {
        super.intializePages();
        mucevherSaatKategorilerPage = new MucevherSaatKategorilerPage(driver);
    }

    @Test
    public void mucevherSaatKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(KategorilerPage.Kategori.MUCEVHER_SAAT);
        Thread.sleep(2000);
        mucevherSaatKategorilerPage.loadCategories();
        mucevherSaatKategorilerPage.clickOnCategory(MucevherSaatKategorilerPage.Kategori.SAAT);
        Thread.sleep(2000);
    }
}
