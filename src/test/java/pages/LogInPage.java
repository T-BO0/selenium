package pages;

import org.openqa.selenium.By;

import base.pages.BasePage;
import base.utilities.SingletonDriver;

public class LogInPage extends BasePage {

    private static By uniqueElementLocator = By
            .xpath("//span[@data-ui-id=\"page-title-wrapper\" and contains(text(),\"Customer Login\")]");

    public LogInPage() {
        super(uniqueElementLocator);
    }

    public By emailTextFieldLocator = By.xpath("//*[@id=\"email\"]");

    public By passwordTextFieldLocator = By.xpath("//*[@id=\"pass\"]");

    public By submitLoginButtonLocator = By.xpath("//*[@id=\"send2\"]");

    public By errorLogInFailedMessageLocator = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public void fillLogInAndSubmit(String email, String password) {
        SingletonDriver.getDriver().findElement(emailTextFieldLocator).sendKeys(email);
        SingletonDriver.getDriver().findElement(passwordTextFieldLocator).sendKeys(password);
        SingletonDriver.getDriver().findElement(submitLoginButtonLocator).click();
    }

    public boolean IsNotLogedIn() {
        return !SingletonDriver.getDriver().findElements(errorLogInFailedMessageLocator).isEmpty();
    }
}
