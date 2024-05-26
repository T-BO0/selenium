package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Step;
import pages.PantsCatalogPage;
import pages.SinglePantsDetailsPage;
import pages.WelcomePage;

public class TestCart extends BaseTest {

    @Step
    @Test(priority = 5)
    public void testAddCart() {
        // setup
        var welcomePage = new WelcomePage();
        var pantsCatalogPage = new PantsCatalogPage();
        var singlePantsDetailsPage = new SinglePantsDetailsPage();
        var quantity = testData.get("quantity").asText();

        // act
        welcomePage.waitTillThePageIsLoaded();
        welcomePage.navigateToMansPantsPage();

        pantsCatalogPage.waitTillThePageIsLoaded();
        pantsCatalogPage.getToTheFirstProductDetails();

        singlePantsDetailsPage.waitTillThePageIsLoaded();
        singlePantsDetailsPage.selectOptionsForPantsAndAddToCart(quantity);

        // assert
        Assert.assertTrue(singlePantsDetailsPage.productIsAdded());
    }

    @Step
    @Test(priority = 6)
    public void testAddCartWithInvalidQuantityShouldFail() {
        // setup
        var welcomePage = new WelcomePage();
        var pantsCatalogPage = new PantsCatalogPage();
        var singlePantsDetailsPage = new SinglePantsDetailsPage();

        // act
        welcomePage.navigateToMansPantsPage();
        pantsCatalogPage.waitTillThePageIsLoaded();
        pantsCatalogPage.getToTheFirstProductDetails();

        singlePantsDetailsPage.waitTillThePageIsLoaded();
        singlePantsDetailsPage.selectOptionsForPantsAndAddToCart("-1");

        // assert
        Assert.assertTrue(singlePantsDetailsPage.productNotAddedInvalidQuantity());
    }
}
