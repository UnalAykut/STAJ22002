package org.example;

public class E2ECategoryTest {
    @SneakyThrows
    @Test(description = TEST_E2E_CATEGORY_004, priority = 4, groups = {"panel", "mobile"})
    public void changeCategoryFromPassiveToActive(){
        MobileHomePage mobileHomePage = new MobileHomePage();
        PanelCategoryPage panelCategoryPage = new PanelCategoryPage();
        PanelNavigationBar panelNavigationBar = new PanelNavigationBar();

        panelNavigationBar.clickCategory();
        Utils.waitForPageToLoad();

        panelCategoryPage.searchByCategoryName("Bebek");
        panelCategoryPage.firstEditCategory();
        wait(5);
        panelCategoryPage.setSlotStatus("active");
        panelCategoryPage.clickSaveButton();
        panelCategoryPage.clickContinueButton();
        panelCategoryPage.verifyTheSuccessMessage("update");

        boolean isCategoryVisible = mobileHomePage.isCategoryPresent("Bebek");
        Assert.assertTrue(isCategoryVisible, "Category 'Bebek' is not visible in the mobile application.");
    }
}
