package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.ModaKategorilerPage;
import test.baseTest.BaseTest;

public class ModaKategorilerPageTest extends BaseTest {
    private ModaKategorilerPage modaKategorilerPage;
    @Override
    public void intializePages() {
        super.intializePages();
        modaKategorilerPage=new ModaKategorilerPage( driver );
    }

    @Test
    public void modaKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory( KategorilerPage.Kategori.MODA);
        Thread.sleep(2000);
        modaKategorilerPage.loadCategories();
        modaKategorilerPage.clickOnCategory(ModaKategorilerPage.Kategori.AYAKKABI_CANTA);
        Thread.sleep(2000);
    }
}
