package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Condition;
import org.selenide.HomePage;
import org.selenide.models.ProductModel;

import java.util.List;

import static stepDefs.HomePageStepDefinitions.softAssertions;

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
        softAssertions.assertThat(actualSize).isEqualTo(expected);
    }

    @And("I check that every product has name")
    public void areAllProductsHasName() {
        List<ProductModel> products = homePage.getProducts();

        softAssertions.assertThatList(products).haveExactly(0, new Condition<ProductModel>() {
            @Override
            public boolean matches(ProductModel value) {
                String name = value.getName();
                return name == null || name.isEmpty();
            }
        });
    }

    @And("I check that every product has price")
    public void areAllProductsHasPrice() {
        List<ProductModel> products = homePage.getProducts();

        softAssertions.assertThatList(products).haveExactly(0, new Condition<ProductModel>() {
            @Override
            public boolean matches(ProductModel value) {
                Float price = value.getNewPrice();
                return price == null || price == 0f;
            }
        });
    }

    @And("I check that all prices bigger than {int}")
    public void areAllProductsHasPriceBiggerThan(int expected) {
        List<ProductModel> products = homePage.getProducts();

        softAssertions.assertThatList(products).haveExactly(0, new Condition<ProductModel>() {
            @Override
            public boolean matches(ProductModel value) {
                return value.getNewPrice() < expected;
            }
        });
    }
}