package org.example;

public class MobileHomePage {
    public boolean isCategoryPresent(String categoryName) {
        MobileUtils.scrollWithDirection("up", "category");
        if (!categoryElementList.isEmpty()) {
            MobileUtils.scrollToElementText(categoryName, "category");
            Optional<WebElement> category = categoryElementList.stream()
                    .filter(option -> option.getText().trim().equalsIgnoreCase(categoryName))
                    .findFirst();
            return category.isPresent();
        } else {
            System.out.println("No categories found in the Home Page.");
            return false;
        }
    }
}
