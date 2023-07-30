package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

    public RegisterPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='field-firstname']")
    public static WebElement fNameElement;

    @FindBy(xpath = "//input[@id='field-lastname']")
    public static WebElement lNameElement;

    @FindBy(xpath = "//input[@id='field-email']")
    public static WebElement emailElement;

    @FindBy(xpath = "//input[@id='field-password']")
    public static WebElement passwordElement;

    @FindBy(xpath = "//input[@id='field-id_gender-1']")
    public static WebElement genderMr;

    @FindBy(xpath = "//input[@name='psgdpr']")
    public static WebElement iAgreeCheckbox;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    public static WebElement customerPrivacyCheckBox;

    @FindBy(xpath = "//button[@class='btn btn-primary form-control-submit float-xs-right']")
    public static WebElement saveButtonElement;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    public static WebElement invalidMessage;

    public void fillRegistrationData(
            String firstName,
            String lastName,
            String email,
            String password
    ) {
        setAttribute(genderMr, "value", "1");
        setAttribute(fNameElement, "value", firstName);
        setAttribute(lNameElement, "value", lastName);
        emailElement.sendKeys("value", email);
        setAttribute(passwordElement, "value", password);
        makeClick(iAgreeCheckbox);
        makeClick(customerPrivacyCheckBox);

    }

    public void clickSaveButton(){
        makeClick(saveButtonElement);
    }

    public String getNameOutlineColor(){
        return fNameElement.getCssValue("outline-color");
    }

    public boolean isPopUpMessageAppears(){
       return invalidMessage.isDisplayed();
    }
}
