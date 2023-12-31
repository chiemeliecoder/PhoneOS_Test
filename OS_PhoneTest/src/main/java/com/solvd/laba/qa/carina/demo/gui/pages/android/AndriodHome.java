package com.solvd.laba.qa.carina.demo.gui.pages.android;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenu;
import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenuBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.AndriodHomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AndriodHomePageBase.class)
public class AndriodHome extends AndriodHomePageBase {

  @FindBy(id = "footercontent")
  private FooterWalmartMenu footerWalmartMenu;

  @FindBy(id = "homepage")
  private ExtendedWebElement pageColumn;

  @FindBy(xpath = "//div[contains(@class, 'category-block')]//a")
  private List<ExtendedWebElement> animeLinks;

  @FindBy(xpath = "//div[@class='site-search']")
  private ExtendedWebElement searchDiv;

  @Context(dependsOn = "searchDiv")
  @FindBy(xpath = ".//input[@type='text']")
  private ExtendedWebElement searchTextField;

  @Context(dependsOn = "searchDiv")
  @FindBy(xpath = ".//button[@type ='submit']")
  private ExtendedWebElement searchButton;

  @FindBy(xpath = "//div[@class = 'product']")
  private List<MerchItem> merch;

  @FindBy(xpath = "//nav[@role='navigation']//button")
  private ExtendedWebElement navigateDiv;


  @FindBy(xpath = "//div[@class = 'menu-group']//li[@class = 'nav-item dropdown']/a")
  private ExtendedWebElement newItems;



  @FindBy(xpath = "//div[@class = 'menu-group']//li[@class = 'dropdown-item dropdown']/a")
  private ExtendedWebElement shopAllNewItems;

  @FindBy(xpath = ".//a[@href = 'https://store.crunchyroll.com/help-center.html']")
  private ExtendedWebElement footerPicks;

  public AndriodHome(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(pageColumn);
  }

  @Override
  public FooterWalmartMenuBase getFooterWalmartMenu() {
    return null;
  }

  @Override
  public CategoryBasePage selectCategory(String name) {
    for (ExtendedWebElement anime : animeLinks) {
      String currentAnime = anime.getText();
      if (name.equalsIgnoreCase(currentAnime)) {
        anime.click();
        return initPage(driver, CategoryBasePage.class);
      }
    }
    throw new RuntimeException("Unable to open anime name: " + name);
  }

  @Override
  public List<MerchItem> searchMerch(String searchInput) {
    searchTextField.type(searchInput);
    searchButton.click();
    return merch;
  }

  @Override
  public MerchProductPageBase navNewItemSelect() {
    newItems.hover();
    newItems.click();
    return new MerchProductPage(driver);
  }
}
