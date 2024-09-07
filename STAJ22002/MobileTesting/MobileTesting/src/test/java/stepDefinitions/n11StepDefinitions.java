package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.N11Pages;
import pages.kategoriler.KategorilerPage;
import util.DriverFactory;

public class n11StepDefinitions {
    N11Pages n11Pages = new N11Pages( DriverFactory.getDriver());
    KategorilerPage kategorilerPage=new KategorilerPage( DriverFactory.getDriver() );
    @When("Kategoriler menüsüne tıklanır")
    public void kategorilerMenüsüneTıklanır() {
        n11Pages.clickKategoriler();
    }

    @And("Elektronik kategorisi seçilir")
    public void elektronikKategorisiSeçilir() throws InterruptedException {
        kategorilerPage.clickOnCategory( KategorilerPage.Kategori.ELEKTRONIK);
        Thread.sleep( 1000 );
    }

    @And("Telefon ve Aksesuarları kategorisi seçilir")
    public void telefonVeAksesuarlarıKategorisiSeçilir() {
    }

    @And("Cep Telefonu kategorisi seçilir")
    public void cepTelefonuKategorisiSeçilir() {
    }

    @And("Marka filtreleme seçeneği belirlenir")
    public void markaFiltrelemeSeçeneğiBelirlenir() {
    }

    @And("Filtreleme menüsüne tıklanır")
    public void filtrelemeMenüsüneTıklanır() {
    }

    @And("Ürünler filtrelenir")
    public void ürünlerFiltrelenir() {
    }

    @And("Sonuçları Göster butonuna tıklanır")
    public void sonuçlarıGösterButonunaTıklanır() {
    }

    @And("Ürün sepete eklenir")
    public void ürünSepeteEklenir() {
    }

    @And("Sepete gidilir")
    public void sepeteGidilir() {
    }

    @Then("Sepetteki ürün kontrol edilir")
    public void sepettekiÜrünKontrolEdilir() {
    }
}
