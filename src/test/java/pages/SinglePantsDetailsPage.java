package pages;

import org.openqa.selenium.By;

import base.pages.BasePage;
import base.utilities.SingletonDriver;
import base.utilities.WaitsUtil;

public class SinglePantsDetailsPage extends BasePage {

    private static By uniqueElement = By.xpath("//div[@class='product-info-main']");

    public SinglePantsDetailsPage() {
        super(uniqueElement);
    }

    public By pantsSizeOptionFirstLocator = By.xpath("//*[@id=\"option-label-size-143-item-175\"]");

    public By pantsColorOptionfirstLocator = By.xpath("//*[@id=\"option-label-color-93-item-49\"]");

    public By pantsQuantityTextFieldLocator = By.xpath("//*[@id=\"qty\"]");

    public By pantsAddToCartButtonLocator = By.xpath("//*[@id=\"product-addtocart-button\"]");

    public By successMessageAddThePantsLocator = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    public By errorMessageQunatityInvalidLocator = By.xpath("//*[@id=\"qty-error\"]");

    public void selectOptionsForPantsAndAddToCart(String quantity) {
        SingletonDriver.getDriver().findElement(pantsSizeOptionFirstLocator).click();
        SingletonDriver.getDriver().findElement(pantsColorOptionfirstLocator).click();
        SingletonDriver.getDriver().findElement(pantsQuantityTextFieldLocator).sendKeys(quantity);
        SingletonDriver.getDriver().findElement(pantsAddToCartButtonLocator).click();
    }

    public boolean productIsAdded() {
        WaitsUtil.WaituntilExists(successMessageAddThePantsLocator, SingletonDriver.getDriver(), 3);
        return !SingletonDriver.getDriver().findElements(successMessageAddThePantsLocator).isEmpty();
    }

    public boolean productNotAddedInvalidQuantity() {
        WaitsUtil.WaituntilExists(errorMessageQunatityInvalidLocator, SingletonDriver.getDriver(), 3);
        return !SingletonDriver.getDriver().findElements(errorMessageQunatityInvalidLocator).isEmpty();
    }
}
