package org.example;

public class PanelBannerPageTest {
    @SneakyThrows
    @Test(description = TEST_P_BANNER_012,groups = "panel")
    public void test(){
        PanelNavigationBar panelNavigationBar=new PanelNavigationBar();
        PanelBannerPage panelBannerPage=new PanelBannerPage();
        panelNavigationBar.clickBanner();
        String sourceTextBanner="Her An Yanında";
        String targetTextBanner="Bir Dilim Daha?";
        String oldNumber= panelBannerPage.getRowNumber( sourceTextBanner );
        panelBannerPage.dragAndDrop(panelBannerPage.getBanner(sourceTextBanner),panelBannerPage.getBanner(targetTextBanner));
        wait(5);
        String newNumber=panelBannerPage.getRowNumber( sourceTextBanner );
        System.out.println("eski="+oldNumber);
        System.out.println("yeni="+newNumber);
        assertFalse(panelBannerPage.dragAndDropControl(oldNumber,newNumber));
    }
}
