package org.example;

public class PannelBannerPage {
    @FindBy(xpath = "//*[@id=\"app\"]//div[contains(@class, 'card-body')]//tr[2]/td[6]/button[1]/a")
    private WebElement editButton;
    @FindBy(xpath = "//button[normalize-space()='Kaydet']")
    private WebElement saveButton;
    @FindBy(xpath = "//a[@class='remove-image']")
    private WebElement removeBannerImage;
    @FindBy(xpath = "//tbody/tr/td[2]/input")
    private WebElement bannerNameSearchBar;
    public void clickEditButton(){
        editButton.click();
    }
    public String getAlertMessage(String transaction) {
        Alert alert = DriverManager.getWebDriver().switchTo().alert();
        String alertMessage = alert.getText().trim();
        return alertMessage;
    }
    public void removeBannerImage() {
        removeBannerImage.click();
    }
    public void saveBanner() {
        savedBanner();
        Utils.waitFor(2);
    }
    public void searchByBannerName(String value) {
        bannerNameSearchBar.sendKeys(value);
    }
}
