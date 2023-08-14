package org.selenide;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductModel;

import java.util.List;

@Slf4j
public class PricesDropPage extends BasePage{

    public PricesDropPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='products row']/*")
    public static List<WebElement> products;

    public List<ProductModel> getProducts() {
        log.info("Getting products");
        return ProductModel.create(products);
    }

}
