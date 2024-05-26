package testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.fasterxml.jackson.databind.JsonNode;
import base.utilities.WorkingWithJson;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.PantsCatalogPage;
import pages.RegisterPage;
import pages.SinglePantsDetailsPage;
import pages.WelcomePage;
import base.utilities.SingletonDriver;

import java.io.IOException;

public class BaseTest {

    protected JsonNode testData;

    public BaseTest() {
    }

    @BeforeClass(groups = { "positive", "negative" })
    public void setUp() throws IOException {
        testData = WorkingWithJson.getResourcesFromJson("testdata/TestData.json");
        var baseUrl = testData.get("baseUrl").asText();
        SingletonDriver.getDriver().get(baseUrl);
    }

    @AfterSuite(groups = { "positive", "negative" })
    public void tearDown() {
        SingletonDriver.getDriver().quit();
    }

}
