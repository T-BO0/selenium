package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.utilities.SingletonDriver;
import base.utilities.WaitsUtil;
import io.qameta.allure.Step;
import pages.LogInPage;
import pages.WelcomePage;

public class TestLogin extends BaseTest {

    @Step
    @Test(priority = 3)
    public void testRegister() {
        // setup
        var password = super.testData.get("password").asText();
        var email = super.testData.get("usedEmail").asText();
        var welcomePage = new WelcomePage();
        var loginPage = new LogInPage();

        // act
        welcomePage.waitTillThePageIsLoaded();
        welcomePage.clickLogIn();

        loginPage.waitTillThePageIsLoaded();
        loginPage.fillLogInAndSubmit(email, password);

        // assert
        WaitsUtil.WaituntilExists(welcomePage.loggedInButtonLocator, SingletonDriver.getDriver(), 3);
        Assert.assertTrue(welcomePage.isLogedIn());

        welcomePage.logOut();
    }

    @Step
    @Test(priority = 4)
    public void testShouldFailLogInWithWrongCredentials() {
        // setup
        var password = super.testData.get("wrongPassword").asText();
        var email = super.testData.get("usedEmail").asText();
        var welcomePage = new WelcomePage();
        var loginPage = new LogInPage();

        // act
        welcomePage.clickLogIn();
        loginPage.waitTillThePageIsLoaded();
        loginPage.fillLogInAndSubmit(email, password);

        // assert
        Assert.assertTrue(loginPage.IsNotLogedIn());
    }
}
