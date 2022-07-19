package org.wikiqa.tests;

import org.junit.jupiter.api.Test;
import org.wikiqa.infra.CoreTestCase;
import org.wikiqa.pages.MainPageObject;
import org.wikiqa.pages.SearchPageObject;
import org.wikiqa.factories.SearchPageObjectFactory;

class SearchTests extends CoreTestCase {
  @Test
  void search() {
    SearchPageObject searchPage = SearchPageObjectFactory.get();
    MainPageObject mainPage = new MainPageObject();


    searchPage.swipeUp(2000);
    searchPage.initSearchInput();
    searchPage.typeSearchLine("Java");
    searchPage.waitForSearchResult("Object-oriented programming language");
  }
}

