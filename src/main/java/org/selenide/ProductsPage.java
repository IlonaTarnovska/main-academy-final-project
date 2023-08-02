package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductWebElementWrapper;

import java.text.Collator;
import java.util.*;

import static org.selenide.utils.Utils.areSortEquals;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    public static WebElement sortingButton;

    @FindBy(xpath = "//div[@class='dropdown-menu']/a[contains(., 'Name, A to Z')]")
    public static WebElement sortingAscending;

    @FindBy(xpath = "//div[@class='products row']/*")
    public static List<WebElement> products;

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

    public void clickAscendingDropdown(){
        makeClick(sortingAscending);
    }

    public boolean checkSortProductByNameAscending() {
        List<ProductWebElementWrapper> original = getProducts();
        List<ProductWebElementWrapper> sorted = new ArrayList<>(original);
        Collator collator = Collator.getInstance(Locale.US);
        Collections.sort(sorted, new Comparator<ProductWebElementWrapper>() {
            @Override
            public int compare(final ProductWebElementWrapper object1, final ProductWebElementWrapper object2) {
                return collator.compare(object1.getName(),object2.getName());
            }
        });
        return areSortEquals(original, sorted);
    }
}

