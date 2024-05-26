package base.utilities;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;

public class SingletonDriver {

    static WebDriver driver = null;

    public static WebDriver getDriver() {

        if (driver == null) {
            String driverName;
            try {
                driverName = WorkingWithJson.getResourcesFromJson("configfiles/config.json").get("browser")
                        .asText();
                driver = DriverFactory.getDriver(driverName);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return driver;
    }

    public static void nullifyTheDriver() {
        driver = null;
    }
}
