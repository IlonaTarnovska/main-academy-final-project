package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenide.models.ProductWebElementWrapper;

import java.text.Collator;
import java.time.Duration;
import java.util.*;

import static org.selenide.utils.Utils.areSortEquals;

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

    private final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public ProductsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<ProductWebElementWrapper> getProducts() {
        List<ProductWebElementWrapper> list = new ArrayList<>();
        for (WebElement item : products) {
            list.add(new ProductWebElementWrapper(item));
        }

        return list;
    }

    public void clickSortingButton() {
        makeClick(sortingButton);
    }

    public void clickAscendingDropdown() {
        makeClick(sortingAscending);
        waitLoader();
    }

    public boolean checkSortProductByNameAscending() {
        List<ProductWebElementWrapper> original = getProducts();
        List<ProductWebElementWrapper> sorted = new ArrayList<>(original);
        Collator collator = Collator.getInstance(Locale.US);
        Collections.sort(sorted, new Comparator<ProductWebElementWrapper>() {
            @Override
            public int compare(final ProductWebElementWrapper object1, final ProductWebElementWrapper object2) {
                return collator.compare(object1.getName(), object2.getName());
            }
        });
        return areSortEquals(original, sorted);
    }

    private void waitLoader() {
        wait.until(ExpectedConditions.visibilityOf(loader));
        wait.until(ExpectedConditions.invisibilityOf(loader));
    }

    public void clickDescendingDropdown() {
        makeClick(sortingDescending);
        waitLoader();
    }

    public boolean checkSortProductByNameDescending() {
        List<ProductWebElementWrapper> original = getProducts();
        List<ProductWebElementWrapper> sorted = new ArrayList<>(original);
        Collator collator = Collator.getInstance(Locale.US);
        Collections.sort(sorted, new Comparator<ProductWebElementWrapper>() {
            @Override
            public int compare(final ProductWebElementWrapper object1, final ProductWebElementWrapper object2) {
                return collator.compare(object2.getName(), object1.getName());
            }
        });
        return areSortEquals(original, sorted);
    }

    public void clickAscendingPriceDropdown() {
        makeClick(sortingPriceAscending);
        waitLoader();
    }

    public boolean checkSortProductByPriceAscending() {
        List<ProductWebElementWrapper> original = getProducts();
        List<ProductWebElementWrapper> sorted = new ArrayList<>(original);
        Collections.sort(sorted, new Comparator<ProductWebElementWrapper>() {
            @Override
            public int compare(final ProductWebElementWrapper object1, final ProductWebElementWrapper object2) {
                return Float.compare(object1.getNewPrice(), object2.getNewPrice());
            }
        });
        return areSortEquals(original, sorted);
    }

    public void clickDescendingPriceDropdown() {
        makeClick(sortingPriceDescending);
        waitLoader();
    }

    public boolean checkSortProductByPriceDescending() {
        List<ProductWebElementWrapper> original = getProducts();
        List<ProductWebElementWrapper> sorted = new ArrayList<>(original);
        Collections.sort(sorted, new Comparator<ProductWebElementWrapper>() {
            @Override
            public int compare(final ProductWebElementWrapper object1, final ProductWebElementWrapper object2) {
                return Float.compare(object2.getNewPrice(), object1.getNewPrice());
            }
        });
        return areSortEquals(original, sorted);
    }
}

