package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductWebElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='products row']/*")
    public static List<WebElement> products;

    public List<ProductWebElementWrapper> getProducts() {
        List<ProductWebElementWrapper> list = new ArrayList<>();
        for (WebElement item : products) {
            list.add(new ProductWebElementWrapper(item));
        }

        return list;
    }

    public void clickOnProductWithText(String text) {
        List<ProductWebElementWrapper> list = getProducts();
        for (ProductWebElementWrapper item: list){
            if (item.getName().equals(text)) {
                makeClick(item.getClickableArea());
                return;
            }
        }
    }
}
