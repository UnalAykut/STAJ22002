package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.EvVeYasamKategorilerPage;
import pages.kategoriler.KategorilerPage;
import test.baseTest.BaseTest;

public class EvVeYasamKategorilerPageTest extends BaseTest {
    private EvVeYasamKategorilerPage evVeYasamKategorilerPage;
    @Override
    public void intializePages() {
        super.intializePages();
        evVeYasamKategorilerPage=new EvVeYasamKategorilerPage( driver );
    }

    @Test
    public void evVeYasamKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory( KategorilerPage.Kategori.EV_YASAM);
        Thread.sleep(2000);
        evVeYasamKategorilerPage.loadCategories();
        evVeYasamKategorilerPage.clickOnCategory( EvVeYasamKategorilerPage.Kategori.MOBILYA);
        Thread.sleep(2000);
    }
}
