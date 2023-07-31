package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductWebElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class PricesDropPage extends BasePage{

    public PricesDropPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='products row']/*")
    public static List<WebElement> products;

    public List<ProductWebElementWrapper> getProducts() {
        List<ProductWebElementWrapper> list = new ArrayList<>();
        for (WebElement item: products) {
            list.add(new ProductWebElementWrapper(item));
        }

        return list;
    }

}
