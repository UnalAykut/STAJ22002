package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.EvcilHayvanUrunleriKategorilerPage;
import pages.kategoriler.KategorilerPage;
import test.baseTest.BaseTest;

public class EvcilHayvanUrunleriKategorilerPageTest extends BaseTest {
    private EvcilHayvanUrunleriKategorilerPage evcilHayvanUrunleriKategorilerPage;

    @Override
    public void intializePages() {
        super.intializePages();
        evcilHayvanUrunleriKategorilerPage = new EvcilHayvanUrunleriKategorilerPage(driver);
    }

    @Test
    public void evcilHayvanUrunleriKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(KategorilerPage.Kategori.PET11);
        Thread.sleep(2000);
        evcilHayvanUrunleriKategorilerPage.loadCategories();
        evcilHayvanUrunleriKategorilerPage.clickOnCategory(EvcilHayvanUrunleriKategorilerPage.Kategori.KEDI);
        Thread.sleep(2000);
    }
}
