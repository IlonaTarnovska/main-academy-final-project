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

    @FindBy(xpath = "//tr[@class='total-value font-weight-bold']")
    public static WebElement orderTotal;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public static WebElement orderSubtotal;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    public static WebElement orderShipping;

    public String getConfirmedTitle() {
        return orderConfirmedTitle.getText();
    }

    public Float getTotal() {
        return Utils.convertPrice(orderTotal.getText());
    }

    public Float getSubtotal() {
        return Utils.convertPrice(orderSubtotal.getText());
    }

    public Float getShipping() {
        return Utils.convertPrice(orderShipping.getText());
    }
}
