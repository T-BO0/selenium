package pages;

import org.openqa.selenium.By;

import base.pages.BasePage;
import base.utilities.SingletonDriver;

public class PantsCatalogPage extends BasePage {

    private static By uniqueElementLocator = By.xpath("//h1[@id='page-title-heading']/span[text()='Pants']");

    public PantsCatalogPage() {
        super(uniqueElementLocator);
    }

    public By pantsCatalogFirstProductSelector = By
            .xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img");

    public void getToTheFirstProductDetails() {
        SingletonDriver.getDriver().findElement(pantsCatalogFirstProductSelector).click();
    }
}
