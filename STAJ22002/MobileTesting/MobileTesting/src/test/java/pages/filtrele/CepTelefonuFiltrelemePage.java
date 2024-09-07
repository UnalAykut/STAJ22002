package pages.filtrele;

import io.appium.java_client.AppiumDriver;
import pages.DisplayNameEnum;

public class CepTelefonuFiltrelemePage extends AbstractFiltrelemePage<CepTelefonuFiltrelemePage.FilterOption> {

   // Bu metodu ihtiyacınıza göre implement edebilirsiniz


    public CepTelefonuFiltrelemePage(AppiumDriver driver) {
        super(driver);
    }

    public enum FilterOption implements DisplayNameEnum {
        KATEGORI("Kategori"),
        ISLEMCİ("İşlemci"),
        MARKA("Marka"),
        BELLEK_KAPASITESI("Bellek Kapasitesi"),
        EKRAN_KARTI_MODELI("Ekran Kartı Modeli"),
        DISK_KAPASITESI("Disk Kapasitesi"),
        EKRAN_BOYUTU("Ekran Boyutu"),
        ISLETIM_SISTEMI("İşletim Sistemi"),
        EKRAN_KARTI_BELLEGI("Ekran Kartı Belleği"),
        ISLEMCI_MODELI("İşlemci Modeli"),
        URUN_TIPI("Ürün Tipi"),
        FIYAT_ARALIGI("Fiyat Aralığı"),
        MAGAZA_PUANI("Mağaza Puanı"),
        MAGAZA_SECIMI("Mağaza Seçimi"),
        KARGO_SECENEKLERI("Kargo Seçenekleri"),
        URUN_PUANI("Ürün Puanı");

        private String displayName;

        FilterOption(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }
    }
}
