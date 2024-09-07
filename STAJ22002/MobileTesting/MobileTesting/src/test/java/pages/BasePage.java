package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.ElementHelper;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BasePage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvListingSearchBar']")
    protected static WebElement searchBarText;
    protected static AppiumDriver driver;
    protected static ElementHelper elementHelper;
    protected String categoryTextXPath = "//android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']";
    protected Map<String, WebElement> kategoriMap = new HashMap<>();

    private static int clickCounter = 0;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getCategoryElements(List<WebElement> categoryList) {
        return categoryList;
    }

    public <T extends Enum<T> & DisplayNameEnum> Map<String, WebElement> loadCategories(List<WebElement> kategoriElements, String categoryTextXPath, Class<T> enumClass) {
        int expectedCategoryCount = enumClass.getEnumConstants().length;
        System.out.println("Enumdan gelen kategori sayisi=>"+expectedCategoryCount);
        return initializeKategoriMap(kategoriElements, categoryTextXPath, expectedCategoryCount);
    }

    private Map<String, WebElement> initializeKategoriMap(List<WebElement> kategoriElements, String textViewXPath, int expectedCategoryCount) {
        Map<String, WebElement> kategoriMap = new HashMap<>();
        int previousSize = 0;

        while (kategoriMap.size() < expectedCategoryCount) {
            updateKategoriMap(kategoriMap, kategoriElements, textViewXPath);

            if (kategoriMap.size() == expectedCategoryCount) {
                break;
            }

            if (kategoriElements.size() > previousSize) {
                previousSize = kategoriElements.size();
                scrollDown();
            } else {
                break;
            }
        }

        return kategoriMap;
    }

    private void updateKategoriMap(Map<String, WebElement> kategoriMap, List<WebElement> kategoriElements, String textViewXPath) {
        System.out.println("-------------------Kategori Eklenen Textler---------------------" );
        for (WebElement element : kategoriElements) {
            WebElement textElement = element.findElement(By.xpath(textViewXPath));
            if (textElement != null) {
                String categoryText = textElement.getText().trim().toLowerCase();
                if (!kategoriMap.containsKey(categoryText)) {
                    kategoriMap.put(categoryText, element);
                    System.out.println("Kategori metni eklendi: " + categoryText);
                }
            } else {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Text element bulunamadı.");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }
        System.out.println("Eklenen Kategori Metni Sayisi=>"+kategoriMap.size());
        System.out.println("----------------------------------------" );
    }

    public static <T extends Enum<T> & DisplayNameEnum> void clickOnCategory(Map<String, WebElement> kategoriMap, T kategori, String textViewXPath) {

        clickCounter++;

        String categoryName = kategori.getDisplayName().trim().toLowerCase();
        WebElement categoryElement = kategoriMap.get(categoryName);

        if (categoryElement == null) {
            categoryElement = scrollToCategory(categoryName, kategoriMap, textViewXPath);
        }

        if (categoryElement != null) {
            clickAndValidateCategory(categoryElement, kategori, textViewXPath);
        } else {
            handleCategoryNotFound(kategori);
        }
    }

    private static <T extends Enum<T> & DisplayNameEnum> void clickAndValidateCategory(WebElement categoryElement, T kategori, String textViewXPath) {
        WebElement textElement = categoryElement.findElement(By.xpath(textViewXPath));
        elementHelper.clickElement(textElement);
        if (clickCounter <= 2) {
            validateCategorySelection(kategori);
        } else {
            System.out.println("2. tıklamadan sonra metin kontrolü yapılmadı.");
            clickCounter = 0;
        }
    }

    private static <T extends Enum<T> & DisplayNameEnum> void validateCategorySelection(T kategori) {
        WebElement textViewElement = elementHelper.waitForVisibility(
                driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryTitle']"))
        );
        String expectedTextViewText = kategori.getDisplayName();
        String actualTextViewText = textViewElement.getText();
        try {
            Assert.assertEquals(actualTextViewText, expectedTextViewText, "TextView'de beklenen metin bulunamadı!");
            System.out.println("Metinler eşleşti => ActualData: " + actualTextViewText + " ExpectedData: " + expectedTextViewText);
            System.out.println("Tıklama işlemi başarılı");
        } catch (AssertionError e) {
            System.err.println("TextView'de beklenen metin bulunamadı! Beklenen: " + expectedTextViewText + ", Gerçek: " + actualTextViewText);
            throw e;
        }
    }

    private static <T extends Enum<T> & DisplayNameEnum> void validateCategoryAndSearchBox(String text) {
        String searchBarTextControl = searchBarText.getText();
        // searchBarTextControl 'text' içeriyor mu?
        if (searchBarTextControl.contains(text)) {
            // Eşleşen textler
            System.out.println("---------------searchBarTextControl---------------------");
            System.out.println("Text Actual: " + searchBarTextControl);
            System.out.println("Text Expected: " + text);
            System.out.println("Tıklama işlemi doğru searchBar kontrolü yapıldı.");
            System.out.println("------------------------------------");
        } else {
            // Eşleşme yoksa
            System.out.println("---------------searchBarTextControl---------------------");
            System.out.println("SearchBar text eşleşmedi");
            System.out.println("Text Actual: " + searchBarTextControl);
            System.out.println("Text Expected: " + text);
            System.out.println("SearchBar tıklama kontrolü başarısız");
            System.out.println("------------------------------------");
        }
    }
    public <T1 extends Enum<T1> & DisplayNameEnum, T2 extends Enum<T2> & DisplayNameEnum> void gezAndValidateCategories(
            PageActions<T1> previousPageActions,//önceki kategori
            PageActions<T2> currentPageActions,//şuan üzerinde yapılan işlem
            T1 previousCategoryEnum
    ) throws InterruptedException {
        // Kategoriler listesini al
        List<WebElement> kategoriler = currentPageActions.categoryList();

        for (int i = 0; i < kategoriler.size(); i++) {
            // Elementi döngü sırasında yeniden alarak 'StaleElementReferenceException' hatasını önleyin
            WebElement kategoriGez = kategoriler.get(i);

            // Elementin görünür olmasını bekleyin
            elementHelper.waitForVisibility(kategoriGez);

            // Tıklama işlemi öncesi metni alın
            WebElement textViewElement = kategoriGez.findElement(By.xpath(".//android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']"));
            String expectedText = textViewElement.getText(); // Tıklanacak olan elementin metni

            // Kategoriye tıklayın
            elementHelper.clickElement(kategoriGez);

            // Kısa bir bekleme
            Thread.sleep(2000);

            // Arama kutusunu doğrulama
            validateCategoryAndSearchBox(expectedText);

            // Geri düğmesine tıklayın
            elementHelper.searchBackButton();

            // Kategorilerin yeniden yüklenmesini bekleyin
            elementHelper.waitForVisibility(previousPageActions.categoryList().get(0));
            previousPageActions.loadCategories();
            previousPageActions.clickOnCategory(previousCategoryEnum);

            // Her döngüde kategorileri yeniden alarak 'StaleElementReferenceException' hatasını önleyin
            kategoriler = currentPageActions.categoryList();
        }
    }





    private static <T extends Enum<T> & DisplayNameEnum> void handleCategoryNotFound(T kategori) {
        System.out.println("Kategori bulunamadı: " + kategori.getDisplayName());
        System.out.println("Enum değerlerini kontrol edin!!");
        System.out.println("Mobil uygulamadaki isimleri kontrol edin!!");
        System.out.println("XPath'leri kontrol edin!!");
    }

    private static WebElement scrollToCategory(String categoryName, Map<String, WebElement> kategoriMap, String textViewXPath) {
        while (!kategoriMap.containsKey(categoryName)) {
            scrollDown();
            for (Map.Entry<String, WebElement> entry : kategoriMap.entrySet()) {
                WebElement element = entry.getValue();
                WebElement textElement = element.findElement(By.xpath(textViewXPath));
                if (textElement.getText().trim().equalsIgnoreCase(categoryName)) {
                    return element;
                }
            }
        }
        return kategoriMap.get(categoryName);
    }

    public static void scrollDown() {
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (driver.manage().window().getSize().height * 0.8);
        int endY = (int) (driver.manage().window().getSize().height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }
}
