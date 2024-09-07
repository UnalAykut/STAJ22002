package pages;



import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.ElementHelper;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BasePageDeneme {
    protected static AppiumDriver driver;
    protected static ElementHelper elementHelper;
    protected String categoryTextXPath = ".//android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvCategoryItem']";
    protected Map<String, WebElement> kategoriMap = new HashMap<>();

    public BasePageDeneme(AppiumDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public <T extends Enum<T> & DisplayNameEnum> Map<String, WebElement> loadCategories(List<WebElement> kategoriElements, String categoryTextXPath, Class<T> enumClass) {
        int expectedCategoryCount = enumClass.getEnumConstants().length;  // Enum'daki eleman sayısını otomatik hesapla
        return initializeKategoriMap(kategoriElements, categoryTextXPath, expectedCategoryCount);
    }

    public List<WebElement> getCategoryElements(List<WebElement> categoryList) {
        return categoryList;
    }

    public Map<String, WebElement> initializeKategoriMap(List<WebElement> kategoriElements, String textViewXPath, int expectedCategoryCount) {
        Map<String, WebElement> kategoriMap = new HashMap<>();
        int previousSize = 0;
        int currentSize = 0;

        while (kategoriMap.size() < expectedCategoryCount) {
            currentSize = kategoriElements.size();
            System.out.println("Kategori eleman sayısı: " + currentSize);

            // Yeni elemanlar için mevcut listeyi tarar
            for (WebElement element : kategoriElements) {
                WebElement textElement = element.findElement(By.xpath(textViewXPath));
                if (textElement != null) {
                    String categoryText = textElement.getText().trim();
                    if (!kategoriMap.containsKey(categoryText.toLowerCase())) {
                        kategoriMap.put(categoryText.toLowerCase(), element);
                        System.out.println("Kategori metni eklendi: " + categoryText);
                    }
                } else {
                    System.out.println("Text element bulunamadı.");
                }
            }

            // Eğer yeni eleman eklenmişse, kaydırma işlemi yapılır
            if (currentSize > previousSize && kategoriMap.size() < expectedCategoryCount) {
                previousSize = currentSize;
                scrollDown();
            } else {
                // Yeni eleman eklenmediyse ve gerekli tüm kategoriler bulunduysa döngüyü kır
                break;
            }
        }

        return kategoriMap;
    }

    private static int clickCounter = 0;

    public static <T extends Enum<T> & DisplayNameEnum> void clickOnCategory(Map<String, WebElement> kategoriMap, T kategori, String textViewXPath) {
        clickCounter++;

        String categoryName = kategori.getDisplayName().trim().toLowerCase();
        WebElement categoryElement = kategoriMap.get(categoryName);

        // Eğer kategori mevcut değilse, kaydırarak bulun
        while (categoryElement == null) {
            scrollDown();
            categoryElement = kategoriMap.get(categoryName);
        }

        if (categoryElement != null) {
            WebElement textElement = categoryElement.findElement(By.xpath(textViewXPath));
            System.out.println("Aranan category element => " + textElement.getText());

            elementHelper.clickElement(textElement);

            if (clickCounter <= 2) {
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
            } else {
                System.out.println("2. tıklamadan sonra metin kontrolü yapılmadı.");
            }
        } else {
            System.out.println("Kategori bulunamadı: " + kategori.getDisplayName());
            System.out.println("Enum değerlerini kontrol edin!!");
            System.out.println("Mobil uygulamadaki isimleri kontrol edin!!");
            System.out.println("XPath'leri kontrol edin!!");
        }
    }

    private static WebElement scrollToCategory(String categoryName, Map<String, WebElement> kategoriMap, String textViewXPath) {
        while (true) { // Sonsuz döngü, öğe bulunana kadar çalışır
            try {
                for (Map.Entry<String, WebElement> entry : kategoriMap.entrySet()) {
                    WebElement element = entry.getValue();
                    WebElement textElement = element.findElement(By.xpath(textViewXPath));
                    if (textElement.getText().trim().equalsIgnoreCase(categoryName)) {
                        kategoriMap.put(categoryName, element);
                        return element;
                    }
                }
            } catch (Exception e) {
                scrollDown();
            }

            // Öğeyi bulduysak döngüden çık
            if (kategoriMap.containsKey(categoryName)) {
                return kategoriMap.get(categoryName);
            }
        }
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

        driver.perform(Arrays.asList(swipe));
    }
}

