package org.example;

public class PanelBannerPageTest {
    @SneakyThrows
    @Test(description = TEST_P_BANNER_010, groups = "panel")
    public void deleteBanner(){
        PanelBannerPage bannerPage = new PanelBannerPage();
        boolean isDeleted = bannerPage.isBannerDeleted();
        Assert.assertTrue(isDeleted);
    }
}
