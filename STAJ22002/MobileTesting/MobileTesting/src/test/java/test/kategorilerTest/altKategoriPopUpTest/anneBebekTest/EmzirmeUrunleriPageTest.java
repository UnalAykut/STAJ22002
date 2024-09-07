package test.kategorilerTest.altKategoriPopUpTest.anneBebekTest;

import org.testng.annotations.Test;
import pages.kategoriler.AnneBebekKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.anneBebek.BanyoTuvaletPage;
import test.baseTest.AbstractBaseCategoryTest;

public class EmzirmeUrunleriPageTest extends AbstractBaseCategoryTest {

    @Test
    public void emzirmeUrunleriKategorilerTest() throws InterruptedException {
        performCategoryTest(KategorilerPage.Kategori.ANNE_BEBEK,
                AnneBebekKategorilerPage.class,
                AnneBebekKategorilerPage.Kategori.EMZIRME_URUNLERI,
                BanyoTuvaletPage.class
        );
    }
}
