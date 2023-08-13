package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.utils.Utils;

public class OrderConfirmedPage extends BasePage {

    public OrderConfirmedPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//h3[@class='h1 card-title']")
    public static WebElement orderConfirmedTitle;

    @FindBy(xpath = "//*[@id='order-items']/div[2]/table/tbody/tr[1]/td[2]")
    public static WebElement orderSubtotal;

    @FindBy(xpath = "//*[@id='order-items']/div[2]/table/tbody/tr[2]/td[2]")
    public static WebElement orderShipping;

    @FindBy(xpath = "//*[@id='order-items']/div[2]/table/tbody/tr[3]/td[2]")
    public static WebElement orderTotal;

    public String getConfirmedTitle() {
        return Utils.removeDoneChar(orderConfirmedTitle.getText());
    }

    public Float getTotal() {
        String tax = orderTotal.getText().replace("TOTAL (TAX INCL.) ", "");
        return Utils.convertPrice(tax);
    }

    public Float getSubtotal() {
        return Utils.convertPrice(orderSubtotal.getText());
    }

    public Float getShipping() {
        return Utils.convertPrice(orderShipping.getText());
    }
}
