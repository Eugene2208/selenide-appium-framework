package org.wikiqa.infra;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.SupportsRotation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.ScreenOrientation;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;

@Tag("mobile")
public class CoreTestCase {

    private AppiumDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        WebDriverRunner.setWebDriver(driver);
        open(PropertiesCache.getInstance().getProperty("siteUrl"));
    }

    @AfterEach
    void tearDown() {
        WebDriverRunner.closeWebDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    protected void rotateScreenPortrait() {
        ((SupportsRotation) driver).rotate(ScreenOrientation.PORTRAIT);
    }
}
