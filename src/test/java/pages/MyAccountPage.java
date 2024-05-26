package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.pages.BasePage;
import base.utilities.SingletonDriver;

public class MyAccountPage extends BasePage {

    private static By uniqueElementLocator = By.xpath("//span[text()='My Account' and @class='base']");

    public MyAccountPage() {
        super(uniqueElementLocator);
    }

    public By successMassageLocator = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div");

    public boolean successMassageElementExists() {
        List<WebElement> successMassage = SingletonDriver.getDriver().findElements(successMassageLocator);

        return successMassage.size() > 0;
    }
}
