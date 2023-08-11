package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenuBase;
import com.solvd.laba.qa.carina.demo.gui.enums.Category;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterMenuBase;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private ExtendedWebElement acceptCookies;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract BrandModelsPageBase selectBrand(String brandName);

    public abstract FooterMenuBase getFooterMenu();

    public abstract CompareModelsPageBase openComparePage();

    public abstract AllBrandsPageBase openAllBrandsPage();

    public abstract FooterWalmartMenuBase getFooterWalmartMenu();

    public abstract CategoryBasePage selectCategory(Category name);

    public abstract List<MerchItem> searchMerch(String searchInput);

    public abstract MerchProductPageBase navNewItemSelect();

    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent(10);
    }

}
