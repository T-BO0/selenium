package pages;

import org.openqa.selenium.By;
import base.pages.BasePage;
import base.utilities.SingletonDriver;

public class RegisterPage extends BasePage {

        private static By uniqueElementLocator = By
                        .xpath("//span[@data-ui-id=\"page-title-wrapper\" and text()=\"Create New Customer Account\"]");

        public RegisterPage() {
                super(uniqueElementLocator);
        }

        public By firstNameTextFieldLocator = By.xpath("//*[@id=\"firstname\"]");
        public By lastNameTextFieldLocator = By.xpath("//*[@id=\"lastname\"]");
        public By emailTextFieldLocator = By.xpath("//*[@id=\"email_address\"]");
        public By passwordFieldLocator = By.xpath("//*[@id=\"password\"]");
        public By confirmPasswordFieldLocator = By.xpath("//*[@id=\"password-confirmation\"]");
        public By createAnAccButtonLocator = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
        public By passwordsDoNotMatchErrorMessageLocator = By.xpath("//*[@id=\"password-confirmation-error\"]");
        public By emailIsTakenErrorMessageLocator = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

        public void fillRegisterForm(String testFirstname, String testLastName, String email, String password,
                        String confirmPassword) {

                SingletonDriver.getDriver().findElement(firstNameTextFieldLocator).sendKeys(testFirstname);

                SingletonDriver.getDriver().findElement(lastNameTextFieldLocator).sendKeys(testLastName);

                SingletonDriver.getDriver().findElement(emailTextFieldLocator).sendKeys(email);

                SingletonDriver.getDriver().findElement(passwordFieldLocator).sendKeys(password);

                SingletonDriver.getDriver().findElement(confirmPasswordFieldLocator).sendKeys(confirmPassword);

                SingletonDriver.getDriver().findElement(createAnAccButtonLocator).click();
        }

        public boolean passwordDoNotMatchErrorMessageExists() {
                return !SingletonDriver.getDriver().findElements(passwordsDoNotMatchErrorMessageLocator).isEmpty();
        }

        public boolean emailIsTakenErrorMessageExists() {
                return !SingletonDriver.getDriver().findElements(emailIsTakenErrorMessageLocator).isEmpty();
        }
}
