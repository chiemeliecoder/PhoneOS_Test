package com.solvd.laba.qa.carina.demo.gui.pages.android;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenu;
import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenuBase;
import com.solvd.laba.qa.carina.demo.gui.enums.Category;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;
import com.zebrunner.carina.webdriver.locator.Context;
import java.lang.invoke.MethodHandles;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.laba.qa.carina.demo.gui.components.footer.MobileFooterMenu;
import com.solvd.laba.qa.carina.demo.gui.pages.common.AllBrandsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[contains(@class, 'general-menu material-card')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(id = "news-container")
    private ExtendedWebElement newsColumn;

    @FindBy(xpath = "//span[@class='menu']")
    private ExtendedWebElement headerMenuButton;

    @FindBy(xpath = "//a[text()='Compare']")
    private ExtendedWebElement compareButton;

    @FindBy(xpath = "//ul[@class='links right']//a[text()='[...]']")
    private ExtendedWebElement allBrandsButton;

    @FindBy(xpath = "//header//nav//ul//a[text()='News']")
    private ExtendedWebElement newsButton;

    @FindBy(xpath = "//footer")
    private MobileFooterMenu footer;

    @FindBy(id = "footercontent")
    private FooterWalmartMenu footerWalmartMenu;

    @FindBy(className = "experience-component experience-commerce_layouts-bannerCarousel")
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

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
    }

    @Override
    public CategoryBasePage selectCategory(Category name){
        LOGGER.info("selecting '" + name + "' name...");
        for (ExtendedWebElement anime : animeLinks) {
            String currentAnime = anime.getText();
            LOGGER.info("currentBrand: " + currentAnime);
            anime.click();
            return initPage(driver, CategoryBasePage.class);
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
    public MerchProductPageBase navNewItemSelect(){
        newItems.hover();
        newItems.click();
        return new MerchProductPage(driver);
    }

    @Override
    public BrandModelsPageBase selectBrand(String brandName) {
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            if (brandName.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return initPage(driver, BrandModelsPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brandName);
    }

    @Override
    public MobileFooterMenu getFooterMenu() {
        return footer;
    }

    @Override
    public CompareModelsPageBase openComparePage() {
        headerMenuButton.click();
        compareButton.click();
        return initPage(driver, CompareModelsPageBase.class);
    }

    @Override
    public AllBrandsPageBase openAllBrandsPage() {
        headerMenuButton.click();
        allBrandsButton.click();
        return initPage(driver, AllBrandsPageBase.class);
    }

    @Override
    public FooterWalmartMenuBase getFooterWalmartMenu() {
        return footerWalmartMenu;
    }

}
