package org.wikiqa.factories;

import com.codeborne.selenide.appium.ScreenObject;
import org.wikiqa.infra.Platform;
import org.wikiqa.pages.AndroidSearchPageObject;
import org.wikiqa.pages.SearchPageObject;
import org.wikiqa.pages.iOSSearchPageObject;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class SearchPageObjectFactory {
  public static SearchPageObject get() {
      return Platform.getInstance().isAndroid() ?
          ScreenObject.screen(AndroidSearchPageObject.class) :
          ScreenObject.screen(iOSSearchPageObject.class);
  }
}
