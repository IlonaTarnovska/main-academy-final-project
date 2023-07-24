package org.selenide;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//p[@id=block-newsletter-label]")
    private WebElement newsLetterLabel;

    @FindBy(xpath = "//div[@class='row'][2]/div[@class='col-xs-12']/p")
    private WebElement unsubscribeMessage;


    @FindBy(xpath = "//input[@class='btn btn-primary float-xs-right hidden-xs-down']")
    public WebElement subscribeButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']/*")
    public List<WebElement> dropdownLanguages;


    public void openHomePage() {
        getDriver().get("https://demo.prestashop.com/");
    }

    public String getNewsLetterLabelText() {
        return newsLetterLabel.getText();
    }

    public String getUnsubscribeMessage() {
        return unsubscribeMessage.getText();
    }

    public boolean checkUpperCase() {
        String buttonText = subscribeButton.getText();
        String upperCasedButton = buttonText.toUpperCase(Locale.ROOT);

        return buttonText.equals(upperCasedButton);
    }

    public int getLanguagesCount() {
        return dropdownLanguages.size();
    }

    public boolean isLanguagePresent(String expectedLanguage) {
        boolean isLangPresent = false;
        for (int i = 0; i < dropdownLanguages.size(); i++) {
            String language = dropdownLanguages.get(i).getText();
            if (language.equals(expectedLanguage)){
                isLangPresent = true;
            }
        }
        return isLangPresent;
    }
}


