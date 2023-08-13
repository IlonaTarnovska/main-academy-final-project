package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Condition;
import org.selenide.HomePage;
import org.selenide.PricesDropPage;
import org.selenide.models.ProductModel;

import java.util.List;

import static stepDefs.HomePageStepDefinitions.softAssertions;

public class PriceDropStepDefinitions {

    //Test case #7 (Price drop check)
    //
    // Go to the https://demo.prestashop.com/
    // At the bottom of the page click on 'Prices drop' link
    // Check that every product has old and new price
    // Check that promo price for every product calculates correct


    private final HomePage homePage = new HomePage();
    private final PricesDropPage priceDropPage = new PricesDropPage();

     @When("I click on 'Prices drop' link at the bottom of the page")
    public void clickOnPricesDropLink(){
         homePage.pricesDropLinkClick();
     }

    @Then("I check that every product has old and new price")
    public void checkPrices(){
        List<ProductModel> list = priceDropPage.getProducts();

        softAssertions.assertThatList(list).haveExactly(0, new Condition<ProductModel>() {
            @Override
            public boolean matches(ProductModel value) {
                return value.getNewPrice() == null && value.getOldPrice() == null;
            }
        });
    }

    @Then("I check that promo price for every product calculates correct")
    public void checkPromoPrices() {
        List<ProductModel> list = priceDropPage.getProducts();

        softAssertions.assertThatList(list).haveExactly(0, new Condition<ProductModel>() {
            @Override
            public boolean matches(ProductModel value) {
                return !value.isCorrectPromoPrice();
            }
        });
    }

}
