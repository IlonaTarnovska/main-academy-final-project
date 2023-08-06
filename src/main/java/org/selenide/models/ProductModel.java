package org.selenide.models;

import org.openqa.selenium.WebElement;
import org.selenide.utils.CollectionUtils;
import org.selenide.utils.Utils;

import java.util.List;

public class ProductModel {

    public static List<ProductModel> create(List<WebElement> list) {
        return CollectionUtils.convert(list, ProductModel::create);
    }

    public static ProductModel create(WebElement root) {
        return new ProductModel(root);
    }

    private final WebElement root;

    public ProductModel(WebElement element) {
        this.root = element;
    }

    public String getName() {
        return Utils.findChildText(root, ".//h2[@class='h3 product-title']");
    }

    public Float getNewPrice() {
        String newPrice = Utils.findChildText(root, ".//div[@class='product-price-and-shipping']/span[@class='price']");
        return Utils.convertPrice(newPrice);
    }

    public Float getOldPrice() {
        String oldPrice = Utils.findChildText(root, ".//div[@class='product-price-and-shipping']/span[@class='regular-price']");
        return Utils.convertPrice(oldPrice);
    }

    public Float getDiscount() {
        String discount = Utils.findChildText(root, ".//li[@class='product-flag discount']");
        return Utils.convertDiscount(discount);
    }

    public boolean isCorrectPromoPrice() {
        Float discount = getDiscount();
        Float newPrice = getNewPrice();
        Float oldPrice = getOldPrice();

        Float discountValue = discount * oldPrice / 100;
        Float calculatedNewPrice = oldPrice - discountValue;

        String formattedNewPrice = String.format("%.02f", calculatedNewPrice);
        return formattedNewPrice.equals(String.format("%.02f", newPrice));
    }
}
