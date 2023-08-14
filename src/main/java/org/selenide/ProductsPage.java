package org.selenide;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductModel;
import org.selenide.utils.CollectionUtils;
import org.selenide.utils.WaitHelper;

import java.util.List;

@Slf4j
public class ProductsPage extends BasePage {

    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    public static WebElement sortingButton;

    @FindBy(xpath = "//div[@class='dropdown-menu']/a[contains(., 'Name, A to Z')]")
    public static WebElement sortingAscending;

    @FindBy(xpath = "//div[@class='products row']/*")
    public static List<WebElement> products;

    @FindBy(xpath = "//div[@class='faceted-overlay']")
    public static WebElement loader;

    @FindBy(xpath = "//div[@class='dropdown-menu']/a[contains(., 'Name, Z to A')]")
    public static WebElement sortingDescending;

    @FindBy(xpath = "//div[@class='dropdown-menu']/a[contains(., 'Price, low to high')]")
    public static WebElement sortingPriceAscending;

    @FindBy(xpath = "//div[@class='dropdown-menu']/a[contains(., 'Price, high to low')]")
    public static WebElement sortingPriceDescending;

    public ProductsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<ProductModel> getProducts() {
        log.info("Getting products");
        return ProductModel.create(products);
    }

    private void sortProducts(WebElement element) {
        log.info("Sorting products");
        makeClick(sortingButton);
        makeClick(element);
        waitLoader();
    }

    public void clickNameAscDropdown() {
        log.info("Clicking name in Asc dropdown");
        sortProducts(sortingAscending);
    }

    public void clickNameDescDropdown() {
        log.info("Clicking name in Desc dropdown");
        sortProducts(sortingDescending);
    }

    public void clickPriceAscDropdown() {
        log.info("Clicking price in Asc dropdown");
        sortProducts(sortingPriceAscending);
    }

    public void clickPriceDescDropdown() {
        log.info("Clicking price in Desc dropdown");
        sortProducts(sortingPriceDescending);
    }

    public List<String> productNames() {
        log.info("Product names");
        return CollectionUtils.convert(getProducts(), ProductModel::getName);
    }

    public List<Float> productPrices() {
        log.info("Product prices");
        return CollectionUtils.convert(getProducts(), ProductModel::getNewPrice);
    }

    private void waitLoader() {
        log.info("Waiting loader");
        WaitHelper.visibility(loader);
        WaitHelper.invisibility(loader);
    }

}

