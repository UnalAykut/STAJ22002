package test.kategorilerTest.altKategoriPopUpTest.evYasamTest;


import org.testng.annotations.Test;
import pages.kategoriler.EvVeYasamKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.anneBebek.BanyoTuvaletPage;
import test.baseTest.AbstractBaseCategoryTest;

public class EvcilHayvanUrunleriPageTest extends AbstractBaseCategoryTest {

    @Test
    public void evcilHayvanUrunleriKategorilerTest() throws InterruptedException {
        performCategoryTest(KategorilerPage.Kategori.EV_YASAM,
                EvVeYasamKategorilerPage.class,
                EvVeYasamKategorilerPage.Kategori.EVCIL_HAYVAN_URUNLERI,
                BanyoTuvaletPage.class
        );
    }
}

