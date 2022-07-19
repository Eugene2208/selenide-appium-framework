package org.wikiqa.pages;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.temporal.ChronoUnit.MILLIS;

public class MainPageObject {
  public void swipeUp(int timeOfSwipeMs) {
    TouchAction action = new TouchAction((PerformsTouchActions) getWebDriver());
    Dimension size = getWebDriver().manage().window().getSize();
    int x = size.width / 2;
    int start_y = (int) (size.height * 0.8);
    int end_y = (int) (size.height * 0.2);


    action
        .press(point(x, start_y))
        .waitAction(WaitOptions.waitOptions(Duration.of(timeOfSwipeMs, MILLIS)))
        .moveTo(point(x, end_y))
        .release()
        .perform();
  }

  public void swipeUpQuick() {
    swipeUp(2000);
  }
}
