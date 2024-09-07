package test.kategorilerTest.altKategoriPopUpTest.elektronikTest;

import org.testng.annotations.Test;
import pages.kategoriler.ElektronikKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.anneBebek.BanyoTuvaletPage;
import test.baseTest.AbstractBaseCategoryTest;

public class TelefonAksesuarlariPageTest extends AbstractBaseCategoryTest {

    @Test
    public void telefonAksesuarlariKategorilerTest() throws InterruptedException {
        performCategoryTest(KategorilerPage.Kategori.ELEKTRONIK,
                ElektronikKategorilerPage.class,
                ElektronikKategorilerPage.Kategori.TELEFON_AKSESUARLARI,
                BanyoTuvaletPage.class
        );
    }
}
