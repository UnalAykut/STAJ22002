package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.SporOutdoorKategorilerPage;
import test.baseTest.BaseTest;

public class SporOutdoorKategorilerPageTest extends BaseTest {
    private SporOutdoorKategorilerPage sporOutdoorKategorilerPage;

    @Override
    public void intializePages() {
        super.intializePages();
        sporOutdoorKategorilerPage = new SporOutdoorKategorilerPage(driver);
    }

    @Test
    public void sporOutdoorKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(KategorilerPage.Kategori.SPOR_OUTDOOR);
        Thread.sleep(2000);
        sporOutdoorKategorilerPage.loadCategories();
        sporOutdoorKategorilerPage.clickOnCategory(SporOutdoorKategorilerPage.Kategori.FITNESS_KONDISYON);
        Thread.sleep(2000);
    }
}
