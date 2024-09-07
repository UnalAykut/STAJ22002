package org.example;

public class PanelBannerPage {
    @FindBy(xpath = "(//button[contains(@class, 'v-icon notranslate mr-2 v-icon--link mdi mdi-delete theme--light')])[1]")
    private WebElement deleteButton;

    public boolean isBannerDeleted(){
        String filterColumn = "Banner Adı";
        String firstDataName = AbstractPageObject.getColumnData(filterColumn).get(0);
        deleteButton.click();
        Utils.waitFor(2);
        List<String> getLastPageData = getColumnData(filterColumn);
        return getLastPageData.stream().noneMatch(x -> x.equals(firstDataName));
    }
}
