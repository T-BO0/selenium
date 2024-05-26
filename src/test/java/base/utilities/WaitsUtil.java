package base.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtil {

    public static void WaituntilExists(By locator, WebDriver driver, int timeInSecs) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecs));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}