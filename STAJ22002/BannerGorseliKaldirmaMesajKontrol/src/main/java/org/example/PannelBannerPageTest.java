package org.example;

public class PannelBannerPageTest {
    @SneakyThrows
    @Test(description = TEST_P_BANNER_011,groups = "panel")
    public void removeBannerImageAndCheckWarningMessage(){
        PanelNavigationBar panelNavigationBar=new PanelNavigationBar();
        PanelBannerPage panelBannerPage=new PanelBannerPage();
        panelNavigationBar.clickBanner();
        String searchText="Bir Dilim Daha?";
        panelBannerPage.searchByBannerName(searchText);
        panelBannerPage.clickEditButton();
        Utils.waitFor(3);
        panelBannerPage.removeBannerImage();
        Utils.waitFor(3);
        panelBannerPage.saveBanner();
        Utils.waitFor(3);
        String expectedMessage = "Banner Görseli alanı boş bırakılamaz!";
        String alertMessageText = panelBannerPage.getAlertMessage( "update" );
        assertEquals(alertMessageText,expectedMessage);
    }
}
