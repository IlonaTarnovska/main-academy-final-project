package org.selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenide.utils.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']/*")
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

    public void openHomePage() {
        getDriver().get("https://demo.prestashop.com/");
        //wait for page loading
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(loadingMessage));
        getDriver().switchTo().frame(iframeFrameOfDemoShop);
    }

    public String getNewsLetterLabelText() {
        return newsLetterLabel.getText();
    }

    public String getUnsubscribeMessage() {
        return unsubscribeMessage.getText();
    }

    public boolean checkUpperCase() {
        String textTransform = subscribeButton.getCssValue("text-transform");;
        return textTransform.equals("uppercase");
    }

    public int getLanguagesCount() {
        return dropdownLanguages.size();
    }

    public boolean isLanguagePresent(String expectedLanguage) {
        boolean isLangPresent = false;
        for (int i = 0; i < dropdownLanguages.size(); i++) {
            String language = dropdownLanguages.get(i).getText();
            if (language.equals(expectedLanguage)) {
                isLangPresent = true;
            }
        }
        return isLangPresent;
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
        ArrayList<String> texts = new ArrayList<String>();
        for (int i = 0; i < clothesPopUp.size(); i++) {
            String text = clothesPopUp.get(i).getText();
            texts.add(text);
        }
        return texts;
    }

    public List<String> getAccessoriesDropdownElement() {
        ArrayList<String> texts = new ArrayList<String>();
        for (int i = 0; i < accessoriesPopUp.size(); i++) {
            String text = accessoriesPopUp.get(i).getText();
            texts.add(text);
        }
        return texts;
    }

    public List<String> getArtDropdownElement() {
        ArrayList<String> texts = new ArrayList<>();
        for (int i = 0; i < artPopUp.size(); i++) {
            String text = artPopUp.get(i).getText();
            texts.add(text);
        }
        return texts;
    }

    public int getPopularProductsCount() {
        return popularProducts.size();
    }

    public int getProductNamesCount() {
        By priceXpath = By.xpath(".//div[@class='product-description']/h3[@class='h3 product-title']");
        List<WebElement> names = popularProductsContainer.findElements(priceXpath);
        return names.size();
    }

    public int getProductPriceCount() {
        return getProductPrices().size();
    }

    public List<Float> getProductPrices() {
        ArrayList<Float> prices = new ArrayList<>();
        By priceXpath = By.xpath(".//div[@class='product-price-and-shipping']/span[@class='price']");
        List<WebElement> webPrices = popularProductsContainer.findElements(priceXpath);
        for (WebElement element: webPrices) {
            try {
                prices.add(Utils.convertPrice(element.getText()));
            } catch (Exception e) {
            }
        }
        System.out.println(Arrays.toString(prices.toArray()));
        return prices;
    }

    public void pricesDropLinkClick() {
        makeClick(pricesDropLink);
    }
}


