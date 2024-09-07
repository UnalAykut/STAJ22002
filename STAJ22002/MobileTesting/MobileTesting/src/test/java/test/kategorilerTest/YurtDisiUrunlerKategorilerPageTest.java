package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.YurtDisiUrunlerKategorilerPage;
import test.baseTest.BaseTest;

public class YurtDisiUrunlerKategorilerPageTest extends BaseTest {
    private YurtDisiUrunlerKategorilerPage yurtDisiUrunlerKategorilerPage;

    @Override
    public void intializePages() {
        super.intializePages();
        yurtDisiUrunlerKategorilerPage = new YurtDisiUrunlerKategorilerPage(driver);
    }

    @Test
    public void yurtDisiUrunlerKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(KategorilerPage.Kategori.YURT_DISINDAN_URUNLER);
        Thread.sleep(2000);
        yurtDisiUrunlerKategorilerPage.loadCategories();
        yurtDisiUrunlerKategorilerPage.clickOnCategory(YurtDisiUrunlerKategorilerPage.Kategori.MODA);
        Thread.sleep(2000);
    }
}
