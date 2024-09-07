package test.kategorilerTest.altKategoriPopUpTest.elektronikTest;

import org.testng.annotations.Test;
import pages.kategoriler.ElektronikKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.anneBebek.BanyoTuvaletPage;
import test.baseTest.AbstractBaseCategoryTest;

public class BilgisayarPageTest extends AbstractBaseCategoryTest {

    @Test
    public void bilgisayarKategorilerTest() throws InterruptedException {
        performCategoryTest(KategorilerPage.Kategori.ELEKTRONIK,
                ElektronikKategorilerPage.class,
                ElektronikKategorilerPage.Kategori.BILGISAYAR,
                BanyoTuvaletPage.class
        );
    }
}
