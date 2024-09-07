package test.filtrelemeTest;

import org.testng.annotations.Test;
import pages.filtrele.CepTelefonuFiltrelemeMarkaPage;
import pages.filtrele.CepTelefonuFiltrelemePage;
import pages.filtrele.FiltrelePage;
import pages.kategoriler.ElektronikKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.elektronik.TelefonAksesuarlariPage;
import test.baseTest.BaseTest;

public class denemeTest extends BaseTest {

    private TelefonAksesuarlariPage telefonAksesuarlariPage;
    private FiltrelePage filtrelePage;
    @Override
    public void intializePages() {
        super.intializePages();
        telefonAksesuarlariPage = new TelefonAksesuarlariPage( driver );
        filtrelePage=new FiltrelePage( driver );
    }

    @Test
    public void cepTelefonuFiltrelemeTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory( KategorilerPage.Kategori.ELEKTRONIK );
        elektronikKategorilerPage.loadCategories();
        elektronikKategorilerPage.clickOnCategory( ElektronikKategorilerPage.Kategori.TELEFON_AKSESUARLARI );
        telefonAksesuarlariPage.loadCategories();
        telefonAksesuarlariPage.clickOnCategory( TelefonAksesuarlariPage.Kategori.CEP_TELEFONU );
        n11Pages.clickFiltrele();
        Thread.sleep( 3000 );
        filtrelePage.ensureFilterExpanded( FiltrelePage.FilterOption.URUN_OZELLIKLERI);
    }
}
