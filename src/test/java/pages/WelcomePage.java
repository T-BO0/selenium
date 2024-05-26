package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import base.pages.BasePage;
import base.utilities.SingletonDriver;
import base.utilities.WaitsUtil;

public class WelcomePage extends BasePage {

    private static By uniqElementLocator = By.className("block-promo-hp");

    public WelcomePage() {
        super(uniqElementLocator);
    }

    public By createUserButtonLocator = By.xpath("//div[@class = 'panel header']/ul/li/a[text()='Create an Account']");
    public By myAccOptionButtonLocator = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    public By logOutButtonLocator = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    public By logInButtonLocator = By.className("authorization-link");
    public By loggedInButtonLocator = By.xpath("//span[@class=\"logged-in\"]");
    public By mansDropDownMenuLocation = By.xpath("//a[@id=\"ui-id-5\"]");
    public By mansBottomDropDownMenuLocator = By.xpath("//*[@id=\"ui-id-18\"]");
    public By mansBottomDropDownPantsManuLocator = By.xpath("//*[@id=\"ui-id-23\"]");

    public void clickCreateUserButton() {
        SingletonDriver.getDriver().findElement(createUserButtonLocator).click();
    }

    public void logOut() {
        SingletonDriver.getDriver().findElement(myAccOptionButtonLocator).click();

        SingletonDriver.getDriver().findElement(logOutButtonLocator).click();
    }

    public void clickLogIn() {
        SingletonDriver.getDriver().findElement(logInButtonLocator).click();
    }

    public boolean isLogedIn() {
        return !SingletonDriver.getDriver().findElements(loggedInButtonLocator).isEmpty();
    }

    public void navigateToMansPantsPage() {
        WaitsUtil.WaituntilExists(mansDropDownMenuLocation, SingletonDriver.getDriver(), 3);
        var mansDropDownMenu = SingletonDriver.getDriver().findElement(mansDropDownMenuLocation);
        new Actions(SingletonDriver.getDriver()).moveToElement(mansDropDownMenu).perform();

        WaitsUtil.WaituntilExists(mansBottomDropDownMenuLocator, SingletonDriver.getDriver(), 3);
        var bottomsDropDownMenu = SingletonDriver.getDriver().findElement(mansBottomDropDownMenuLocator);
        new Actions(SingletonDriver.getDriver()).moveToElement(bottomsDropDownMenu).perform();

        WaitsUtil.WaituntilExists(mansBottomDropDownPantsManuLocator, SingletonDriver.getDriver(), 3);
        var pantsDropDownMenu = SingletonDriver.getDriver().findElement(mansBottomDropDownPantsManuLocator);
        new Actions(SingletonDriver.getDriver()).moveToElement(pantsDropDownMenu).click().perform();
    }
}
