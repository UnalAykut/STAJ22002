package pages.kategoriler.altKategoriPopUp.elektronik;

import io.appium.java_client.AppiumDriver;
import pages.AbstractCategoryPage;
import pages.DisplayNameEnum;

public class BeyazEsyaPage extends AbstractCategoryPage<BeyazEsyaPage.Kategori>{
    public BeyazEsyaPage(AppiumDriver driver) {
        super( driver );
    }

    public enum Kategori implements DisplayNameEnum {
        ENDUSTRIYEL_BEYAZ_ESYALAR("Endüstriyel Beyaz Eşyalar"),
        ANKASTRE("Ankastre"),
        ASPIRATOR("Aspiratör"),
        BULASIK_MAKINESI("Bulaşık Makinesi"),
        BUZDOLABI("Buzdolabı"),
        CAMASIR_MAKINESI("Çamaşır Makinesi"),
        DERIN_DONDURUCU("Derin Dondurucu"),
        KURUTMA_MAKINESI("Kurutma Makinesi"),
        PISIRME_GRUBU("Pişirme Grubu"),
        SU_SEBILI("Su Sebili"),
        SARAP_SOGUTUCU("Şarap Soğutucu"),
        YEDEK_PARCA_AKSESUAR("Yedek Parça & Aksesuar"),
        DIGER_BEYAZ_ESYALAR("Diğer Beyaz Eşyalar"),
        ISITMA_SOGUTMA("Isıtma & Soğutma");
        private final String displayName;

        Kategori(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }
    }
    @Override
    protected Class<Kategori> getCategoryEnumClass() {
        return Kategori.class;
    }

}
