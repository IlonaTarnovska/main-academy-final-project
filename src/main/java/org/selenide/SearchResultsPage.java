package org.selenide;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductModel;

import java.util.List;

@Slf4j
public class SearchResultsPage extends BasePage {

    public SearchResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='products row']/*")
    public static List<WebElement> products;

    public List<ProductModel> getProducts() {
        log.info("Getting products");
        return ProductModel.create(products);
    }

    public void clickOnProductWithText(String text) {
        log.info("Clicking on product with text");
        List<ProductModel> list = getProducts();
        for (ProductModel item : list) {
            if (item.getName().equals(text)) {
                makeClick(item.getClickableArea());
                return;
            }
        }
    }
}
