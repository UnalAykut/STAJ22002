package org.example;

public class PanelBannerPage {
    public WebElement getBanner(String text) {
        String dynamicXpath = "//span[contains(text(), '" + text + "')]";
        return DriverManager.getWebDriver().findElement(By.xpath(dynamicXpath));
    }

    public String getRowNumber(String text) {
        String dynamicXpath = "//tr[td//span[contains(text(), '" + text + "')]]/td[1]";
        return DriverManager.getWebDriver().findElement(By.xpath(dynamicXpath)).getText().trim();
    }

    public boolean dragAndDropControl(String oldNumber,String newNumber ){
        if (oldNumber.equalsIgnoreCase(newNumber)){
            return true;
        }
        return false;
    }
}
