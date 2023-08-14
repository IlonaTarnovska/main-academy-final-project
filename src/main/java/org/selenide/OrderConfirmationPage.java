package org.selenide;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.selenide.utils.Utils;
import org.selenide.utils.WaitHelper;

@Slf4j
public class OrderConfirmationPage extends BasePage{

    public OrderConfirmationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='field-firstname']")
    public static WebElement fNameElement;

    @FindBy(xpath = "//input[@id='field-lastname']")
    public static WebElement lNameElement;

    @FindBy(xpath = "//input[@id='field-email']")
    public static WebElement emailElement;

    @FindBy(xpath = "//input[@id='field-id_gender-1']")
    public static WebElement genderMr;

    @FindBy(xpath = "//*[@id='customer-form']/div/div[8]/div[1]/span/label")
    public static WebElement iAgreeCustomerFormCheckbox;

    @FindBy(xpath = "//*[@id='customer-form']/div/div[10]/div[1]/span/label")
    public static WebElement privacyCustomerFormCheckBox;

    @FindBy(xpath = "//*[@id='customer-form']/footer/button")
    public static WebElement continueButtonCustomerForm;

    @FindBy(xpath = "//*[@id='delivery-address']/div/footer/button")
    public static WebElement continueButtonAddressForm;

    @FindBy(xpath = "//*[@id='js-delivery']/button")
    public static WebElement continueButtonDeliveryForm;

    @FindBy(xpath = "//input[@id='field-address1']")
    public static WebElement addressElement;

    @FindBy(xpath = "//input[@id='field-postcode']")
    public static WebElement zipCodeElement;

    @FindBy(xpath = "//input[@id='field-city']")
    public static WebElement cityElement;

    @FindBy(xpath = "//input[@id='delivery_option_2']")
    public static WebElement myCarrierElement;

    @FindBy(xpath = "//input[@id='payment-option-3']")
    public static WebElement paymentChooseElement;

    @FindBy(xpath = "//div[@id='cart-subtotal-products']/span[@class='value']")
    public static WebElement subtotalElement;

    @FindBy(xpath = "//div[@id='cart-subtotal-shipping']/span[@class='value']")
    public static WebElement shippingElement;

    @FindBy(xpath = "//div[@class='cart-summary-line cart-total']/span[@class='value']")
    public static WebElement totalElement;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    public static WebElement agreeTermsConditions;

    @FindBy(xpath = "//*[@id='payment-confirmation']/div[1]/button")
    public static WebElement placeOrderButton;

    @FindBy(xpath = "//select[@id='field-id_country']")
    public static WebElement countryDropdown;

    @FindBy(xpath = "//select[@id='field-id_state']")
    public static WebElement stateDropdown;

    public void fillPersonalData(String firstName, String lastName, String email) {
        log.info("Filling personal information in order confirmation page");
        setAttribute(genderMr, "value", "1");
        setAttribute(fNameElement, "value", firstName);
        setAttribute(lNameElement, "value", lastName);
        emailElement.sendKeys("value", email);
        makeClick(iAgreeCustomerFormCheckbox);
        makeClick(privacyCustomerFormCheckBox);

        WaitHelper.clickable(continueButtonCustomerForm);
        makeClick(continueButtonCustomerForm);
    }

    public void fillAddressInfo(String address, String zipCode, String city){
        log.info("Filling address information in order confirmation page");
        if (stateDropdown.isDisplayed()) {
            Select state = new Select(stateDropdown);
            state.selectByVisibleText("AA");

            Select country = new Select(countryDropdown);
            country.selectByVisibleText("France");
        }

        setAttribute(addressElement, "value", address);
        setAttribute(zipCodeElement, "value", zipCode);
        setAttribute(cityElement, "value", city);

        WaitHelper.clickable(continueButtonAddressForm);
        makeClick(continueButtonAddressForm);
    }

    public void chooseShippingMethod(){
        log.info("Choosing shipping method");
        makeClick(myCarrierElement);

        WaitHelper.clickable(continueButtonDeliveryForm);
        makeClick(continueButtonDeliveryForm);
    }

    public void choosePaymentMethod(){
        log.info("Choosing Payment Method");
        makeClick(paymentChooseElement);
    }

    public Float getSubtotal() {
        log.info("Getting subtotal");
        return Utils.convertPrice(subtotalElement.getText());
    }

    public Float getShipping() {
        log.info("Getting shipping");
        return Utils.convertPrice(shippingElement.getText());
    }

    public Float getTotal() {
        log.info("Getting total");
        return Utils.convertPrice(totalElement.getText());
    }

    public void confirmOrder() {
        log.info("Confirming Order");
        WaitHelper.clickable(agreeTermsConditions);
        makeClick(agreeTermsConditions);

        WaitHelper.clickable(placeOrderButton);
        makeClick(placeOrderButton);
    }
}
