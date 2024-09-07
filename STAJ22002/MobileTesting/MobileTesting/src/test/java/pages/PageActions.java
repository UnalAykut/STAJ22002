package pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface PageActions<T extends Enum<T> & DisplayNameEnum> {
    void loadCategories();
    void clickOnCategory(T category);
    List<WebElement> categoryList();
}

