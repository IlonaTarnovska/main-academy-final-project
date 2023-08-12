package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductCartModel;
import org.selenide.utils.Utils;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='cart-items']/*")
    public static List<WebElement> products;

    @FindBy(xpath = "//div[@class='cart-summary-line']/span[@class='value']")
    public static WebElement totalPrice;

    @FindBy(xpath = "//div[@class='text-sm-center']/a[@class='btn btn-primary']")
    public static WebElement proceedToCheckoutButton;

    public List<ProductCartModel> getProducts() {
        return ProductCartModel.create(products);
    }

    public Float getCalculatedTotalPrice() {
        Float calculated = 0F;
        List<ProductCartModel> list = getProducts();
        for (ProductCartModel item : list) {
            calculated += item.getNewPrice() * item.getQuantity();
        }
        return calculated;
    }

    public Float getTotalPrice(){
        return Utils.convertPrice(totalPrice.getText());
    }

    public void clickProceedToCheckoutButton() {
        makeClick(proceedToCheckoutButton);
    }
}

