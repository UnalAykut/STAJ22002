package test.kategorilerTest;


import org.testng.annotations.Test;
import pages.kategoriler.ElektronikKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.elektronik.BilgisayarPage;
import test.baseTest.BaseTest;


public class ElektronikKategorilerPageTest extends BaseTest {
    private BilgisayarPage bilgisayarPage;
    @Override
    public void intializePages() {
        super.intializePages();
        bilgisayarPage=new BilgisayarPage( driver );
    }

    @Test
    public void elektronikKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(KategorilerPage.Kategori.ELEKTRONIK);
        Thread.sleep(2000);
        elektronikKategorilerPage.loadCategories();
        elektronikKategorilerPage.clickOnCategory( ElektronikKategorilerPage.Kategori.BILGISAYAR );
        Thread.sleep( 2000 );
        bilgisayarPage.loadCategories();
        bilgisayarPage.clickOnCategory( BilgisayarPage.Kategori.DIZUSTU_BILGISAYAR );
        Thread.sleep( 2000 );
    }

}
