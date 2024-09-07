package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.AnneBebekKategorilerPage;
import pages.kategoriler.KategorilerPage;
import test.baseTest.BaseTest;


public class AnneBebekKategorilerPageTest extends BaseTest {

    @Test
    public void anneBebekKategorilerKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory( KategorilerPage.Kategori.ANNE_BEBEK);
        Thread.sleep(2000);
        anneBebekKategorilerPage.loadCategories();
        anneBebekKategorilerPage.clickOnCategory( AnneBebekKategorilerPage.Kategori.BEBEK_ARABALARI );
        Thread.sleep( 2000 );
    }

}
