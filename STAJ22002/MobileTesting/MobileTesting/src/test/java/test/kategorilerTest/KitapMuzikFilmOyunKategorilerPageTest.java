package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.KitapMuzikFilmOyunKategorilerPage;
import test.baseTest.BaseTest;

public class KitapMuzikFilmOyunKategorilerPageTest extends BaseTest {
    private KitapMuzikFilmOyunKategorilerPage kitapMuzikFilmOyunKategorilerPage;

    @Override
    public void intializePages() {
        super.intializePages();
        kitapMuzikFilmOyunKategorilerPage = new KitapMuzikFilmOyunKategorilerPage(driver);
    }

    @Test
    public void kitapMuzikFilmOyunKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(KategorilerPage.Kategori.KITAP_MUZIK_FILM_OYUN);
        Thread.sleep(2000);
        kitapMuzikFilmOyunKategorilerPage.loadCategories();
        kitapMuzikFilmOyunKategorilerPage.clickOnCategory(KitapMuzikFilmOyunKategorilerPage.Kategori.KITAP);
        Thread.sleep(2000);
    }
}
