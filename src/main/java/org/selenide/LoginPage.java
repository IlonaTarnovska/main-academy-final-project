package org.selenide;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='no-account']/a")
    public WebElement registrationButton;

    public void clickRegistrationButton() {
        makeClick(registrationButton);
    }
}
