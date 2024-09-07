package org.example;

public class PanelCategoryPage {
    @FindBy(xpath = "//button[contains(@class, 'btn-light-primary') and contains(text(), 'Tamam')]")
    private WebElement notFoundProductAssociatedSubCategoryPopupButton;
    public void clickNotFoundProductAssociatedSubCategoryButton(){
        Utils.waitForVisibility(notFoundProductAssociatedSubCategoryPopupButton,3);
        notFoundProductAssociatedSubCategoryPopupButton.click();
        Utils.waitFor(2);
    }
    public void setCategoryStatus(String status) {
        Utils.scrollDown(DriverManager.getWebDriver(), 600);
        Utils.scrollDown(DriverManager.getWebDriver(), 700);
        Utils.waitFor(2);
        Utils.waitForVisibility(statusSlider, 5);
        if (status.equalsIgnoreCase("active")) {
            System.out.println("Status before action: " + statusInput.isSelected());
            if (!statusInput.isSelected()) {
                statusSlider.click();
                Utils.waitFor(2);
                System.out.println("Status after action: " + statusInput.isSelected());
            }
        } else if (status.equalsIgnoreCase("passive")) {
            System.out.println("Status before action: " + statusInput.isSelected());
            if (statusInput.isSelected()) {
                statusSlider.click();
                Utils.waitFor(2);
                System.out.println("Status after action: " + statusInput.isSelected());
            }
        }
    }
    public void searchByCategoryName(String name) {
        Utils.waitForVisibility(searchNameCategoryField,3);
        searchNameCategoryField.clear();
        searchNameCategoryField.sendKeys(name);
        Utils.waitFor(3);
    }
    public void clickDataTableEditButtonWithGivenCategoryName(String categoryName) {
        String xpath = "//tr[td/a[contains(text(), \"" + categoryName + "\")]]//button[span]";
        WebElement editButton = DriverManager.getWebDriver().findElement(By.xpath(xpath));
        Utils.waitForVisibility(editButton, 5);
        editButton.click();
        Utils.waitFor(2);
    }

    public boolean checkTheStatusOfTheFeaturedOnOffSwitchButton() {
        Utils.waitForVisibility(statusSlider, 3);
        return statusInput.isSelected();
    }
}
