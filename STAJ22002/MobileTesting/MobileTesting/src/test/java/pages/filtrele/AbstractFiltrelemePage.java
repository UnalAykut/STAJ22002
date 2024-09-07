package pages.filtrele;

import io.appium.java_client.AppiumDriver;
import pages.BasePage;
import pages.DisplayNameEnum;

public abstract class AbstractFiltrelemePage<T extends Enum<T> & DisplayNameEnum> extends BasePage {
    public AbstractFiltrelemePage(AppiumDriver driver) {
        super( driver );
    }


}
