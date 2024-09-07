package pages.filtrele;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FiltrelePage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Teslimat Adresi Seç' or " +
            "@text='Kampanya ve İndirimler' or " +
            "@text='Ürün Özellikleri' or " +
            "@text='Fiyat Aralığı' or " +
            "@text='Mağaza' or " +
            "@text='Teslimat ve Kargo' or " +
            "@text='Yurt Dışından Gelsin' or " +
            "@text='Kullanıcı Değerlendirmeleri']")
    private List<WebElement> filtrelemeOptions;
    public FiltrelePage(AppiumDriver driver) {
        super( driver );
    }
    public enum FilterOption {
        TESLIMAT_ADRESI_SEC("Teslimat Adresi Seç"),
        KAMPANYA_VE_INDIRIMLER("Kampanya ve İndirimler"),
        URUN_OZELLIKLERI("Ürün Özellikleri"),
        FIYAT_ARALIGI("Fiyat Aralığı"),
        MAGAZA("Mağaza"),
        TESLIMAT_VE_KARGO("Teslimat ve Kargo"),
        YURT_DISINDAN_GELSIN("Yurt Dışından Gelsin"),
        KULLANICI_DEGERLENDIRMELERI("Kullanıcı Değerlendirmeleri");

        private final String displayName;

        FilterOption(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public void ensureFilterExpanded(FilterOption filterOption) {
        for (WebElement option : filtrelemeOptions) {
            if (option.getText().equalsIgnoreCase(filterOption.getDisplayName())) {
                WebElement parent = option.findElement(By.xpath(".."));
                WebElement expandButton = parent.findElement(By.xpath(".//android.widget.ImageView"));

                // Seçilen filtre için kapalı mı kontrol edilir
                if (!isOptionExpanded(option)) {
                    // Eğer kapalıysa, açılır ve mesaj yazdırılır
                    expandButton.click();
                    System.out.println(filterOption.getDisplayName() + " kapalıydı, açıldı.");
                } else {
                    System.out.println(filterOption.getDisplayName() + " zaten açıktı.");
                }
                break;  // İlgili filtre bulunduktan sonra döngüden çıkılır
            }
        }
    }

    private boolean isOptionExpanded(WebElement option) {
        // Burada, ">" veya "v" simgesine göre kontrol edilebilir
        // Örneğin, "v" simgesi açık olduğu anlamına gelebilir
        String attributeValue = option.getAttribute("contentDescription");
        return attributeValue != null && attributeValue.contains("açık");
    }

}
