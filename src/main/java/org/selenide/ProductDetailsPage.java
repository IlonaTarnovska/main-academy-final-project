package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenide.utils.Utils;

import java.time.Duration;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//select[@class='form-control form-control-select']")
    public WebElement paperTypeDropdown;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    public WebElement quantityInput;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//h4[@id='myModalLabel']")
    public WebElement modelWindowTitle;

    @FindBy(xpath = "//span[@class='paper type']/strong")
    public WebElement paperTypeWebElement;

    @FindBy(xpath = "//span[@class='product-quantity']/strong")
    public WebElement quantityTypeWebElement;

    @FindBy(xpath = "//p[@class='product-price']")
    public WebElement modalPriceWebElement;

    @FindBy(xpath = "//span[@class='subtotal value']")
    public WebElement modalSubtotalWebElement;

    private final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public void paperTypeDropdownClick(String text) {
        Select paperType = new Select(paperTypeDropdown);
        paperType.selectByVisibleText(text);
    }

    public void setQuantity(String quantity) {
        //TODO: this line doesn't work
        setAttribute(quantityInput, "value", quantity);
        //quantityInput.sendKeys("value", quantity);
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        makeClick(addToCartButton);
    }

    public String getModalWindowTitle() {
        wait.until(ExpectedConditions.visibilityOf(modelWindowTitle));
        return modelWindowTitle.getText();
    }

    public String modalWindowPaperType(){
        return paperTypeWebElement.getText();
    }

    public String modalWindowQuantity(){
        return quantityTypeWebElement.getText();
    }

    public Float modalSubtotal() {
        String subtotal = modalSubtotalWebElement.getText();
        return Utils.convertPrice(subtotal);
    }

    public Float modalCalculatedSubtotal() {
        Float subtotal = Utils.convertPrice(modalPriceWebElement.getText());
        Integer quantity = Integer.parseInt(modalWindowQuantity());
        return subtotal * quantity;
    }
}


