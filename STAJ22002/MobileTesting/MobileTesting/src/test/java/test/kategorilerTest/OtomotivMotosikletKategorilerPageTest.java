package test.kategorilerTest;

import org.testng.annotations.Test;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.OtomotivMotosikletKategorilerPage;
import test.baseTest.BaseTest;

public class OtomotivMotosikletKategorilerPageTest extends BaseTest {
    private OtomotivMotosikletKategorilerPage otomotivMotosikletKategorilerPage;

    @Override
    public void intializePages() {
        super.intializePages();
        otomotivMotosikletKategorilerPage = new OtomotivMotosikletKategorilerPage(driver);
    }

    @Test
    public void otomotivMotosikletKategorilerValueTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        Thread.sleep(2000);
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory(KategorilerPage.Kategori.OTOMOTIV_MOTOSIKLET);
        Thread.sleep(2000);
        otomotivMotosikletKategorilerPage.loadCategories();
        otomotivMotosikletKategorilerPage.clickOnCategory(OtomotivMotosikletKategorilerPage.Kategori.AKSESUAR_TUNING);
        Thread.sleep(2000);
    }
}
