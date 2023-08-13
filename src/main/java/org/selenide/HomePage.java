package org.selenide;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductModel;
import org.selenide.utils.CollectionUtils;
import org.selenide.utils.WaitHelper;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='loadingMessage']")
    private WebElement loadingMessage;

    @FindBy(xpath = "//iframe[@id='framelive']")
    private WebElement iframeFrameOfDemoShop;

    @FindBy(xpath = "//p[@id='block-newsletter-label']")
    private WebElement newsLetterLabel;

    @FindBy(xpath = "//div[@class='col-md-7 col-xs-12']/form/div/div[2]/p")
    private WebElement unsubscribeMessage;

    @FindBy(xpath = "//input[@class='btn btn-primary float-xs-right hidden-xs-down']")
    public WebElement subscribeButton;

    @FindBy(xpath = "//*[@id='_desktop_language_selector']/div/div/button")
    public WebElement dropdownLanguagesButton;

    @FindBy(xpath = "//*[@id='_desktop_language_selector']/div/div/ul")
    public WebElement dropdownLanguagesContainer;

    @FindBy(xpath = "//*[@id='_desktop_language_selector']/div/div/ul/*")
    public List<WebElement> dropdownLanguages;

    @FindBy(xpath = "//span[@class='hidden-sm-down']")
    public WebElement signInButton;

    @FindBy(xpath = "//a[@class='account']/span[@class='hidden-sm-down']")
    public WebElement loggedInUserName;

    @FindBy(xpath = "//li[@id='category-3']/a")
    public WebElement clothesButton;

    @FindBy(xpath = "//li[@id='category-3']/div/ul/*")
    public List<WebElement> clothesPopUp;

    @FindBy(xpath = "//li[@id='category-6']/a")
    public WebElement accessoriesButton;

    @FindBy(xpath = "//li[@id='category-6']/div/ul/*")
    public List<WebElement> accessoriesPopUp;

    @FindBy(xpath = "//li[@id='category-9']/a")
    public WebElement artButton;

    @FindBy(xpath = "//li[@id='category-9']/div/ul/*")
    public List<WebElement> artPopUp;

    @FindBy(xpath = "//div[@class='products row']")
    public WebElement popularProductsContainer;

    @FindBy(xpath = "//div[@class='products row']/*")
    public List<WebElement> popularProducts;

    @FindBy(xpath = "//a[@id='link-product-page-prices-drop-1']")
    public WebElement pricesDropLink;

    @FindBy(xpath = "//a[@class='all-product-link float-xs-left float-md-right h4']")
    public WebElement allProductsLink;

    @FindBy(xpath = "//input[@class='ui-autocomplete-input']")
    public WebElement searchField;

    public void openHomePage() {
        getDriver().get("https://demo.prestashop.com/");
        //wait for page loading
        WaitHelper.invisibility(loadingMessage, 20);
        getDriver().switchTo().frame(iframeFrameOfDemoShop);
    }

    public String getNewsLetterLabelText() {
        return newsLetterLabel.getText();
    }

    public String getUnsubscribeMessage() {
        return unsubscribeMessage.getText();
    }

    public boolean checkUpperCase() {
        String textTransform = subscribeButton.getCssValue("text-transform");
        return textTransform.equals("uppercase");
    }

    public int getLanguagesCount() {
        makeClick(dropdownLanguagesButton);
        return dropdownLanguages.size();
    }

    public List<String> getLanguages() {
        return CollectionUtils.convert(dropdownLanguages, WebElement::getText);
    }

    public void clickSignInButton() {
        makeClick(signInButton);
    }

    public String getLoggedInUserName() {
        return loggedInUserName.getText();
    }

    public void hoverMouseOnClothesButton() {
        hoverMouse(clothesButton);
    }

    public void hoverMouseOnAccessoriesButton() {
        hoverMouse(accessoriesButton);
    }

    public void hoverMouseOnArtButton() {
        hoverMouse(artButton);
    }

    public List<String> getClothesDropdownElement() {
        return CollectionUtils.convert(clothesPopUp, WebElement::getText);
    }

    public List<String> getAccessoriesDropdownElement() {
        return CollectionUtils.convert(accessoriesPopUp, WebElement::getText);
    }

    public List<String> getArtDropdownElement() {
        return CollectionUtils.convert(artPopUp, WebElement::getText);
    }

    public int getPopularProductsCount() {
        return popularProducts.size();
    }

    public List<ProductModel> getProducts() {
        return ProductModel.create(popularProducts);
    }

    public void pricesDropLinkClick() {
        makeClick(pricesDropLink);
    }

    public void clickAllProductsLink() {
        makeClick(allProductsLink);
    }

    public void fillSearchField(String text) {
        searchField.sendKeys(Keys.CLEAR);
        searchField.sendKeys(text);
    }

    public void enterSearchField() {
        searchField.sendKeys(Keys.ENTER);
    }


}


