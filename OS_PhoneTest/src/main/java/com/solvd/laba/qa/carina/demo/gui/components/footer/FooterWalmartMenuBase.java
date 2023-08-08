package com.solvd.laba.qa.carina.demo.gui.components.footer;

import com.solvd.laba.qa.carina.demo.gui.pages.android.FAQPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterWalmartMenuBase extends AbstractUIObject {

  public FooterWalmartMenuBase(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }

  public abstract FAQPage openFAQPage() throws InterruptedException;
}
