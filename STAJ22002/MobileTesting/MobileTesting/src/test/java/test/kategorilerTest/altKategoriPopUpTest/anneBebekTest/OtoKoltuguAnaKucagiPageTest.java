package test.kategorilerTest.altKategoriPopUpTest.anneBebekTest;

import org.testng.annotations.Test;
import pages.kategoriler.AnneBebekKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.anneBebek.BanyoTuvaletPage;
import test.baseTest.AbstractBaseCategoryTest;

public class OtoKoltuguAnaKucagiPageTest extends AbstractBaseCategoryTest {
    @Test
    public void otoKoltuguAnaKucagiKategorilerTest() throws InterruptedException {
        performCategoryTest(KategorilerPage.Kategori.ANNE_BEBEK,
                AnneBebekKategorilerPage.class,
                AnneBebekKategorilerPage.Kategori.OTO_KOLTUGU_ANA_KUCAGI,
                BanyoTuvaletPage.class
        );
    }
}
