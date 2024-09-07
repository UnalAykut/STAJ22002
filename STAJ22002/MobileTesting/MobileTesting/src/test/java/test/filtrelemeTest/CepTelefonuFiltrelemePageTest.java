package test.filtrelemeTest;

import org.testng.annotations.Test;
import pages.filtrele.CepTelefonuFiltrelemeMarkaPage;
import pages.filtrele.CepTelefonuFiltrelemePage;
import pages.kategoriler.ElektronikKategorilerPage;
import pages.kategoriler.KategorilerPage;
import pages.kategoriler.altKategoriPopUp.elektronik.TelefonAksesuarlariPage;
import test.baseTest.BaseTest;

public class CepTelefonuFiltrelemePageTest extends BaseTest {
    private CepTelefonuFiltrelemePage cepTelefonuFiltrelemePage;
    private TelefonAksesuarlariPage telefonAksesuarlariPage;
    private CepTelefonuFiltrelemeMarkaPage cepTelefonuFiltrelemeMarka;
    @Override
    public void intializePages() {
        super.intializePages();
        cepTelefonuFiltrelemePage = new CepTelefonuFiltrelemePage(driver);
        telefonAksesuarlariPage=new TelefonAksesuarlariPage( driver );
        cepTelefonuFiltrelemeMarka=new CepTelefonuFiltrelemeMarkaPage(driver);
    }
    @Test
    public void cepTelefonuFiltrelemeTest() throws InterruptedException {
        n11Pages.clickKategoriler();
        kategorilerPage.loadCategories();
        kategorilerPage.clickOnCategory( KategorilerPage.Kategori.ELEKTRONIK );
        elektronikKategorilerPage.loadCategories();
        elektronikKategorilerPage.clickOnCategory( ElektronikKategorilerPage.Kategori.TELEFON_AKSESUARLARI);
        telefonAksesuarlariPage.loadCategories();
        telefonAksesuarlariPage.clickOnCategory( TelefonAksesuarlariPage.Kategori.CEP_TELEFONU );
        n11Pages.clickFiltrele();
        Thread.sleep( 2000 );

        Thread.sleep( 2000 );
    }


}
