package org.wikiqa.pages.web;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchWidget {

  SelenideElement searchField=$("#searchInput");

  public void search(String searchString){
    searchField.setValue(searchString).pressEnter();
  }
}
