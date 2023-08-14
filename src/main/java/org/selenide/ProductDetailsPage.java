package org.selenide;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.selenide.utils.Utils;
import org.selenide.utils.WaitHelper;

@Slf4j
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

    @FindBy(xpath = "//textarea[@placeholder='Your message here']")
    public static WebElement productCustomizationField;

    @FindBy(xpath = "//button[@class='btn btn-primary float-xs-right']")
    public static WebElement saveCustomizationButton;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public static WebElement modalContinueShoppingButton;

    @FindBy(xpath = "//input[@title='Black']")
    public static WebElement colorSelectorBlack;

    @FindBy(xpath = "//div[@class='cart-content-btn']/a[@class='btn btn-primary']")
    public static WebElement modalProceedToCheckoutButton;


    public void paperTypeDropdownClick(String text) {
        log.info("Clicking on paper type dropdown");
        Select paperType = new Select(paperTypeDropdown);
        paperType.selectByVisibleText(text);
    }

    public void setQuantity(String quantity) {
        //TODO: this line doesn't work
        quantityInput.sendKeys("");
        quantityInput.sendKeys(quantity);
        //setAttribute(quantityInput, "value", quantity);
        //quantityInput.sendKeys("value", quantity);
    }

    public void clickAddToCartButton() {
        log.info("Clicking on add to cart button");
        WaitHelper.clickable(addToCartButton);
        makeClick(addToCartButton);
    }

    public String getModalWindowTitle() {
        log.info("Getting modal window title");
        WaitHelper.visibility(modelWindowTitle);
        return Utils.removeDoneChar(modelWindowTitle.getText());
    }

    public String modalWindowPaperType() {
        log.info("Modal window paper type");
        return paperTypeWebElement.getText();
    }

    public String modalWindowQuantity() {
        log.info("Modal window quantity");
        return quantityTypeWebElement.getText();
    }

    public Float modalSubtotal() {
        log.info("Modal subtotal");
        String subtotal = modalSubtotalWebElement.getText();
        return Utils.convertPrice(subtotal);
    }

    public Float modalCalculatedSubtotal() {
        log.info("Modal calculated subtotal");
        Float subtotal = Utils.convertPrice(modalPriceWebElement.getText());
        Integer quantity = Integer.parseInt(modalWindowQuantity());
        return subtotal * quantity;
    }

    public void fillCustomizeField(String text) {
        log.info("Filling customize field");
        productCustomizationField.sendKeys(Keys.TAB);
        productCustomizationField.clear();
        productCustomizationField.sendKeys(text);
    }

    public void clickOnSaveCustomizationButton() {
        log.info("Clicking on save customization button");
        makeClick(saveCustomizationButton);
    }

    public void clickOnContinueShoppingButton(){
        log.info("Clicking on continue shopping button");
    makeClick(modalContinueShoppingButton);
    }

    public void clickOnColorSelectorBlack(){
        log.info("Clicking on color selector Black");
        makeClick(colorSelectorBlack);
    }

    public void  clickOnModalProceedToCheckoutButton(){
        log.info("Clicking on modal proceed to checkout button");
        WaitHelper.visibility(modalProceedToCheckoutButton);
        makeClick(modalProceedToCheckoutButton);
    }

}

