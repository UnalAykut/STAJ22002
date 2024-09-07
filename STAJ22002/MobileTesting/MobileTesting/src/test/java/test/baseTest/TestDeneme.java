package test.baseTest;

import org.testng.annotations.Test;
import pages.kategoriler.AnneBebekKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.anneBebek.BanyoTuvaletPage;

public class TestDeneme extends AbstractBaseCategoryTest {

    @Test
    public void banyoTuvaletKategorilerTest() throws InterruptedException {
        performCategoryTest(KategorilerPage.Kategori.ANNE_BEBEK,
                AnneBebekKategorilerPage.class,
                AnneBebekKategorilerPage.Kategori.BANYO_TUVALET,
                BanyoTuvaletPage.class
                );
    }
}
