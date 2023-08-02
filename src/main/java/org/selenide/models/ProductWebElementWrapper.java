package org.selenide.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenide.utils.Utils;

public class ProductWebElementWrapper {

    private final WebElement root;

    public ProductWebElementWrapper(WebElement element) {
        this.root = element;
    }

    public String getName(){
        By nameXpath = By.xpath(".//h2[@class='h3 product-title']");
        String name = "";
        try {
            WebElement element = root.findElement(nameXpath);
            name = element.getText();
        } catch (Exception e) {
        }
        return name;

    }
    public Float getNewPrice() {
        return getPrice(".//div[@class='product-price-and-shipping']/span[@class='price']");
    }

    public Float getOldPrice() {
        return getPrice(".//div[@class='product-price-and-shipping']/span[@class='regular-price']");
    }

    public Float getDiscount() {
        By discountXpath = By.xpath(".//li[@class='product-flag discount']");
        Float discount = null;
        try {
            WebElement element = root.findElement(discountXpath);
            discount = Utils.convertDiscount(element.getText());
        } catch (Exception e) {
        }
        return discount;
    }

    private Float getPrice(String xpath) {
        By priceXpath = By.xpath(xpath);
        Float price = null;
        try {
            WebElement element = root.findElement(priceXpath);
            price = Utils.convertPrice(element.getText());
        } catch (Exception e) {
        }
        return price;
    }

    public boolean isCorrectPromoPrice() {
        Float discount = getDiscount();
        Float oldPrice = getOldPrice();

        Float discountValue = discount * oldPrice / 100;
        Float newPrice = oldPrice - discountValue;

        String formattedNewPrice = String.format("%.02f", newPrice);
        return formattedNewPrice.equals(String.format("%.02f", getNewPrice()));
    }
}
