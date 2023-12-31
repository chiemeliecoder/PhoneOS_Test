package com.solvd.laba.qa.carina.demo.gui.components.footer;

import com.solvd.laba.qa.carina.demo.gui.pages.android.FAQPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterWalmartMenu extends FooterWalmartMenuBase{

  @FindBy(linkText = "All Departments")
  private ExtendedWebElement allDepartmentsLink;

  @FindBy(linkText = "Store Directory")
  private ExtendedWebElement storeDirectoryLink;

  //a[@href = 'https://store.crunchyroll.com/help-center.html']
  @FindBy(linkText = "FAQ")
  private ExtendedWebElement fAQLink;

  public FooterWalmartMenu(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }


  @Override
  public FAQPage openFAQPage() throws InterruptedException {
    fAQLink.scrollTo();
    fAQLink.wait(10);
    fAQLink.click();
    return new FAQPage(driver);
  }
}
