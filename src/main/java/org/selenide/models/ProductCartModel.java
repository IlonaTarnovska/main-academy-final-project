package org.selenide.models;

import org.openqa.selenium.WebElement;
import org.selenide.utils.CollectionUtils;
import org.selenide.utils.Utils;

import java.util.List;

public class ProductCartModel {

    public static List<ProductCartModel> create(List<WebElement> list) {
        return CollectionUtils.convert(list, ProductCartModel::create);
    }

    public static ProductCartModel create(WebElement root) {
        return new ProductCartModel(root);
    }
    private final WebElement root;

    public ProductCartModel(WebElement element){
        this.root = element;
    }

    public Float getNewPrice() {
        String newPrice = Utils.findChildText(root, ".//span[@class='price']");
        return Utils.convertPrice(newPrice);
    }

    public Integer getQuantity(){
        String quantity = Utils.findChild(root, ".//input[@class='js-cart-line-product-quantity form-control']")
                .getAttribute("value");
        return Utils.convertToInt(quantity);
    }
}
