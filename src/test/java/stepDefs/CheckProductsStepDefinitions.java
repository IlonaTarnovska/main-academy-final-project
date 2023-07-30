package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.selenide.HomePage;

import java.util.List;

public class CheckProductsStepDefinitions {

    //Test case #6 (Check popular products)
    //
    // Go to the https://demo.prestashop.com/
    // Check that 8 products exist in 'POPULAR PRODUCTS' section
    // Check that every product has name
    // Check that every product has price
    // Check that all prices bigger than 0.00

    HomePage homePage = new HomePage();

    @When("I check that {int} products exist in 'POPULAR PRODUCTS' section")
    public void isExpectedCountExist(int expected) {
        int actualSize = homePage.getPopularProductsCount();
        Assertions.assertThat(actualSize).isEqualTo(expected);
    }

    @And("I check that every product has name")
    public void areAllProductsHasName() {
        int actualSize = homePage.getProductNamesCount();
        int expectedSize = homePage.getPopularProductsCount();

        Assertions.assertThat(actualSize).isEqualTo(expectedSize);
    }

    @And("I check that every product has price")
    public void areAllProductsHasPrice() {
        int actualSize = homePage.getProductPriceCount();
        int expectedSize = homePage.getPopularProductsCount();

        Assertions.assertThat(actualSize).isEqualTo(expectedSize);
    }

    @And("I check that all prices bigger than {int}")
    public void areAllProductsHasPriceBiggerThan(int expected) {
        List<Float> prices = homePage.getProductPrices();

        Assertions.assertThatList(prices).haveExactly(0, new Condition<Float>() {
            @Override
            public boolean matches(Float value) {
                return value < expected;
            }
        });
    }
}