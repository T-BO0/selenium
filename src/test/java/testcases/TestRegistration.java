package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.node.ObjectNode;

import base.utilities.GenerateRandomEmail;
import io.qameta.allure.Step;
import pages.MyAccountPage;
import pages.RegisterPage;
import pages.WelcomePage;

public class TestRegistration extends BaseTest {

    @Step
    @Test(groups = "positive")
    public void testRegistrationShouldRegisterAUser() {
        // setup
        ((ObjectNode) testData).put("email", GenerateRandomEmail.generateRandomEmail());
        var firstname = super.testData.get("firstname").asText();
        var lastname = super.testData.get("lastname").asText();
        var email = super.testData.get("email").asText();
        var password = super.testData.get("password").asText();
        var confirmPassword = super.testData.get("password").asText();
        var welcomePage = new WelcomePage();
        var registerPage = new RegisterPage();
        var myAccountPage = new MyAccountPage();

        // act
        welcomePage.waitTillThePageIsLoaded();
        welcomePage.clickCreateUserButton();

        registerPage.fillRegisterForm(firstname, lastname, email, password, confirmPassword);

        // assert
        myAccountPage.waitTillThePageIsLoaded();
        Assert.assertTrue(myAccountPage.successMassageElementExists());

        welcomePage.logOut();

    }

    @Step
    @Test(groups = "negative")
    public void testPasswordsDoNotMatch() {
        // setup
        ((ObjectNode) testData).put("email", GenerateRandomEmail.generateRandomEmail());
        var firstname = super.testData.get("firstname").asText();
        var lastname = super.testData.get("lastname").asText();
        var email = super.testData.get("email").asText();
        var password = super.testData.get("password").asText();
        var confirmPassword = super.testData.get("wrongPassword").asText();
        var welcomePage = new WelcomePage();
        var registerPage = new RegisterPage();

        // act
        welcomePage.clickCreateUserButton();

        registerPage.waitTillThePageIsLoaded();
        registerPage.fillRegisterForm(firstname, lastname, email, password, confirmPassword);

        // assert
        Assert.assertTrue(registerPage.passwordDoNotMatchErrorMessageExists());
    }

    @Step
    @Test(groups = "negative")
    public void testAlreadyTakenUserShouldReturnErrorMessage() {
        // setup
        var firstname = super.testData.get("firstname").asText();
        var lastname = super.testData.get("lastname").asText();
        var email = super.testData.get("usedEmail").asText();
        var password = super.testData.get("password").asText();
        var confirmPassword = super.testData.get("password").asText();
        var welcomePage = new WelcomePage();
        var registerPage = new RegisterPage();

        // act
        welcomePage.clickCreateUserButton();

        registerPage.waitTillThePageIsLoaded();
        registerPage.fillRegisterForm(firstname, lastname, email, password, confirmPassword);

        // assert
        Assert.assertTrue(registerPage.emailIsTakenErrorMessageExists());
    }
}
