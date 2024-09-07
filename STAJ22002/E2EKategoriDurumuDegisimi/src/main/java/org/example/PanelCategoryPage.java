package org.example;

public class PanelCategoryPage {
    @FindBy(xpath = "//div[@aria-labelledby='swal2-title']//h2")
    private static WebElement afterTransactionPopUpMessage;

    @FindBy(xpath = "//button[contains(text(),'Kaydet')]")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='v-card__actions']//button[contains(text(),'Devam Et')]")
    private static WebElement continueButtonOnPopup;

    @FindBy(xpath = "//div[contains(text(),'Durum')]/following-sibling::div//label/span")
    WebElement statusSlider;

    @FindBy(xpath = "//div[contains(text(),'Durum')]/following-sibling::div//label/input")
    WebElement statusInput;

    @FindBy(xpath = "(//i[@class='far fa-edit'])[1]")
    private WebElement firstEditButton;

    @FindBy(xpath = "//table//tr/td/input[@type='text']")
    private WebElement searchNameCategoryField;
    public void setSlotStatus(String status){
        Utils.scrollDown(DriverManager.getWebDriver(), 600);
        Utils.waitFor(2);
        Utils.waitForVisibility(statusSlider, 5);
        if(status.equalsIgnoreCase("active")){
            System.out.println("Status before action: " + statusInput.isSelected());
            if(!statusInput.isSelected()){
                statusSlider.click();
                Utils.waitFor(2);
                System.out.println("Status after action: " + statusInput.isSelected());
            }
        }else if(status.equalsIgnoreCase("passive")){
            System.out.println("Status before action: " + statusInput.isSelected());
            if(statusInput.isSelected()){
                statusSlider.click();
                Utils.waitFor(2);
                System.out.println("Status after action: " + statusInput.isSelected());
            }
        }
        public void clickSaveButton(){
            saveButton.click();
        }

        public void clickContinueButton(){
            Utils.waitForVisibility(continueButtonOnPopup, 5);
            continueButtonOnPopup.click();
        }

        public void verifyTheSuccessMessage(String transaction){
            Utils.waitForVisibility(afterTransactionPopUpMessage, 10);
            if(transaction.equalsIgnoreCase("update")){
                Assert.assertEquals(afterTransactionPopUpMessage.getText().trim(), "Kategori bilgisi güncellendi!");
            }
        }

        public void firstEditCategory(){
            firstEditButton.click();
        }

        public void searchByCategoryName(String name){
            searchNameCategoryField.clear();
            searchNameCategoryField.sendKeys(name);
        }
}
