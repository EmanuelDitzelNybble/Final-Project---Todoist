package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Safari implements IBrowser {
    @Override
    public WebDriver create() {
        SafariDriver driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        return driver;

    }
}
