package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.selenide.HomePage;
import org.selenide.ProductsPage;
import org.selenide.utils.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

public class SortingCheckStepDefinitions {

    //Test case #8 (Sorting check)
    //
    // Go to the https://demo.prestashop.com/
    // Click on the 'All products >' under the 'POPULAR PRODUCTS' section
    // Sort products as 'Name, A to Z'
    // Check that sorting is correct
    // Sort products as 'Name, Z to A'
    // Check that sorting is correct
    // Sort products as 'Price, low to high'
    // Check that sorting is correct (if price has discount, check regular price not discount)
    // Sort products as 'Price, high to low'
    // Check that sorting is correct (if price has discount, check regular price not discount)

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    SoftAssertions softAssertions = new SoftAssertions();

    @When("I click on the 'All products >' under the 'POPULAR PRODUCTS' section")
    public void clickOnAllProductsLink() {
        homePage.clickAllProductsLink();
    }

    @Then("I sort products as 'Name, A to Z'")
    public void sortingProductByNameAscending() {
        productsPage.clickNameAscDropdown();
    }

    @Then("I check that sorting by name ascending is correct")
    public void checkingByNameAscending() {
        List<String> productNames = productsPage.productNames();
        List<String> sorted = CollectionUtils.sortAscString(productNames);

        softAssertions.assertThatList(productNames).isEqualTo(sorted);
    }

    @Then("I sort products as 'Name, Z to A'")
    public void sortingProductByNameDescending() {
        productsPage.clickNameDescDropdown();
    }

    @Then("I check that sorting by name descending is correct")
    public void checkingByNameDescending() {
        List<String> productNames = productsPage.productNames();
        List<String> sorted = CollectionUtils.sortDescString(productNames);

        softAssertions.assertThatList(productNames).isEqualTo(sorted);
    }

    @Then("I sort products as 'Price, low to high'")
    public void sortingByPriceAscending() {
        productsPage.clickPriceAscDropdown();
    }

    @Then("I check that sorting by Price ascending is correct")
    public void checkingByPriceAscending() {
        List<Float> productPrices = productsPage.productPrices();
        List<Float> sorted = CollectionUtils.sortAscFloat(productPrices);

        softAssertions.assertThatList(productPrices).isEqualTo(sorted);
    }
    @Then("I sort products as 'Price, high to low'")
    public void sortingByPriceDescending() {
        productsPage.clickPriceDescDropdown();
    }

    @Then("I check that sorting by Price Descending is correct")
    public void checkingByPriceDescending() {
        List<Float> productPrices = productsPage.productPrices();
        List<Float> sorted = CollectionUtils.sortDescFloat(productPrices);

        softAssertions.assertThatList(productPrices).isEqualTo(sorted);
    }
}