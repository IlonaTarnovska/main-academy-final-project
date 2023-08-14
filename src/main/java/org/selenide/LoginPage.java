package org.selenide;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='no-account']/a")
    public WebElement registrationButton;

    public void clickRegistrationButton() {
        log.info("Clicking on the registration button");
        makeClick(registrationButton);
    }
}
