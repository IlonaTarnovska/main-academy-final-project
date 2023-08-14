package org.selenide;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenide.models.ProductModel;
import org.selenide.utils.CollectionUtils;
import org.selenide.utils.WaitHelper;

import java.util.List;

@Slf4j
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
        log.info("Opening main page of the application");
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
        log.info("Checking upper case");
        String textTransform = subscribeButton.getCssValue("text-transform");
        return textTransform.equals("uppercase");
    }

    public int getLanguagesCount() {
        log.info("Getting Languages Count");
        makeClick(dropdownLanguagesButton);
        return dropdownLanguages.size();
    }

    public List<String> getLanguages() {
        log.info("Getting Languages");
        return CollectionUtils.convert(dropdownLanguages, WebElement::getText);
    }

    public void clickSignInButton() {
        log.info("Clicking on sign in Button");
        makeClick(signInButton);
    }

    public String getLoggedInUserName() {
        log.info("Getting logged in user Name");
        return loggedInUserName.getText();
    }

    public void hoverMouseOnClothesButton() {
        log.info("Hovering mouse on clothes button");
        hoverMouse(clothesButton);
    }

    public void hoverMouseOnAccessoriesButton() {
        log.info("Hovering mouse on Accessories button");
        hoverMouse(accessoriesButton);
    }

    public void hoverMouseOnArtButton() {
        log.info("Hovering mouse on Art button");
        hoverMouse(artButton);
    }

    public List<String> getClothesDropdownElement() {
        log.info("Getting clothes dropdown element");
        return CollectionUtils.convert(clothesPopUp, WebElement::getText);
    }

    public List<String> getAccessoriesDropdownElement() {
        log.info("Getting accessories dropdown element");
        return CollectionUtils.convert(accessoriesPopUp, WebElement::getText);
    }

    public List<String> getArtDropdownElement() {
        log.info("Getting Art dropdown element");
        return CollectionUtils.convert(artPopUp, WebElement::getText);
    }

    public int getPopularProductsCount() {
        log.info("Getting popular products count");
        return popularProducts.size();
    }

    public List<ProductModel> getProducts() {
        log.info("Getting products");
        return ProductModel.create(popularProducts);
    }

    public void pricesDropLinkClick() {
        log.info("Clicking on prices drop link ");
        makeClick(pricesDropLink);
    }

    public void clickAllProductsLink() {
        log.info("Clicking on All Products link");
        makeClick(allProductsLink);
    }

    public void fillSearchField(String text) {
        log.info("Filling the search field");
        searchField.sendKeys(Keys.CLEAR);
        searchField.sendKeys(text);
    }

    public void enterSearchField() {
        log.info("Entering the search field");
        searchField.sendKeys(Keys.ENTER);
    }


}


