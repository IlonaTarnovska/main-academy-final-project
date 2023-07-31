package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.selenide.HomePage;
import org.selenide.PricesDropPage;
import org.selenide.models.ProductWebElementWrapper;

import java.util.List;

public class PriceDropStepDefinitions {

    //Test case #7 (Price drop check)
    //
    // Go to the https://demo.prestashop.com/
    // At the bottom of the page click on 'Prices drop' link
    // Check that every product has old and new price
    // Check that promo price for every product calculates correct


    private HomePage homePage = new HomePage();
    private PricesDropPage priceDropPage = new PricesDropPage();

     @When("I click on 'Prices drop' link at the bottom of the page")
    public void clickOnPricesDropLink(){
         homePage.pricesDropLinkClick();
     }

    @Then("I check that every product has old and new price")
    public void checkPrices(){
        List<ProductWebElementWrapper> list = priceDropPage.getProducts();

        Assertions.assertThatList(list).haveExactly(0, new Condition<ProductWebElementWrapper>() {
            @Override
            public boolean matches(ProductWebElementWrapper value) {
                return value.getNewPrice() == null && value.getOldPrice() == null;
            }
        });
    }

    @Then("I check that promo price for every product calculates correct")
    public void checkPromoPrices() {
        List<ProductWebElementWrapper> list = priceDropPage.getProducts();

        Assertions.assertThatList(list).haveExactly(0, new Condition<ProductWebElementWrapper>() {
            @Override
            public boolean matches(ProductWebElementWrapper value) {
                return !value.isCorrectPromoPrice();
            }
        });
    }

}
