package test.kategorilerTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.baseTest.BaseTest;


public class KategorilerPageTest extends BaseTest {

    @Test(priority = 0)
     public void kategorilerTest() {
        if (driver == null) {
            throw new RuntimeException( "Driver null, test çalıştırılamaz!" );
        }
        n11Pages.clickKategoriler();
        for (WebElement kategoriGez : kategorilerPage.categoryList()) {//kategorileri gez
            elementHelper.waitForClickability( kategoriGez);//kategorilerdeki ögelerin yüklenmesini bekle
            kategoriGez.click();//kategorileredeki ögeye tıkla
            elementHelper.clickBackButton();
            elementHelper.waitForVisibility(kategorilerPage.categoryList().get(0));//kategori listesi tekrar yüklenmesi bekle
        }
    }

    }



