package base.pages;

import org.openqa.selenium.By;

import base.utilities.SingletonDriver;
import base.utilities.WaitsUtil;

public abstract class BasePage {

    public By uniqElementLocator;

    public BasePage(By uniqElementLocator) {
        this.uniqElementLocator = uniqElementLocator;
    }

    public void waitTillThePageIsLoaded() {
        WaitsUtil.WaituntilExists(uniqElementLocator, SingletonDriver.getDriver(), 3);
    }
}
