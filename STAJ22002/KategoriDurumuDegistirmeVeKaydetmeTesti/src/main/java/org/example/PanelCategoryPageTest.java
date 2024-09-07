package org.example;

public class PanelCategoryPageTest {
    @SneakyThrows
    @Test(description = TEST_P_CATEGORY_007, groups = {"panel"} )
    public void changeTheStatusAndCheck() {
        PanelCategoryPage panelCategoryPage = new PanelCategoryPage();

        String categoryName = "Test Kategorisi 2";
        String theStatusOfCategoryAtBeginning = "active";
        String theStatusOfCategoryAtEnd = "passive";

        //First make it active
        panelCategoryPage.searchByCategoryName(categoryName);
        panelCategoryPage.clickDataTableEditButtonWithGivenCategoryName(categoryName);
        Utils.waitFor(2);
        panelCategoryPage.clickNotFoundProductAssociatedSubCategoryButton();
        panelCategoryPage.setCategoryStatus(theStatusOfCategoryAtBeginning);
        panelCategoryPage.clickSaveButton();
        panelCategoryPage.clickContinueButton();

        //Control if it is active and then make it passive
        panelCategoryPage.searchByCategoryName(categoryName);
        panelCategoryPage.clickDataTableEditButtonWithGivenCategoryName(categoryName);
        isStatusActive = panelCategoryPage.checkTheStatusOfTheFeaturedOnOffSwitchButton();
        assertTrue(isStatusActive);
        Utils.waitFor(2);
        panelCategoryPage.clickNotFoundProductAssociatedSubCategoryButton();
        panelCategoryPage.setCategoryStatus(theStatusOfCategoryAtEnd);
        panelCategoryPage.clickSaveButton();
        panelCategoryPage.clickContinueButton();

        //Control if it is passive and then make it as previous(active)
        panelCategoryPage.searchByCategoryName(categoryName);
        panelCategoryPage.clickDataTableEditButtonWithGivenCategoryName(categoryName);
        isStatusActive  = panelCategoryPage.checkTheStatusOfTheFeaturedOnOffSwitchButton();
        assertFalse(isStatusActive );
        Utils.waitFor(2);
        panelCategoryPage.clickNotFoundProductAssociatedSubCategoryButton();
        panelCategoryPage.setCategoryStatus(theStatusOfCategoryAtBeginning);
        panelCategoryPage.clickSaveButton();
        panelCategoryPage.clickContinueButton();
    }
}
