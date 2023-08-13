package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductModel;
import org.selenide.utils.CollectionUtils;
import org.selenide.utils.WaitHelper;

import java.util.List;

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
        return ProductModel.create(products);
    }

    private void sortProducts(WebElement element) {
        makeClick(sortingButton);
        makeClick(element);
        waitLoader();
    }

    public void clickNameAscDropdown() {
        sortProducts(sortingAscending);
    }

    public void clickNameDescDropdown() {
        sortProducts(sortingDescending);
    }

    public void clickPriceAscDropdown() {
        sortProducts(sortingPriceAscending);
    }

    public void clickPriceDescDropdown() {
        sortProducts(sortingPriceDescending);
    }

    public List<String> productNames() {
        return CollectionUtils.convert(getProducts(), ProductModel::getName);
    }

    public List<Float> productPrices() {
        return CollectionUtils.convert(getProducts(), ProductModel::getNewPrice);
    }

    private void waitLoader() {
        WaitHelper.visibility(loader);
        WaitHelper.invisibility(loader);
    }

}

