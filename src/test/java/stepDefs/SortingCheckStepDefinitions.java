package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.selenide.HomePage;
import org.selenide.ProductsPage;

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
        productsPage.clickSortingButton();
        productsPage.clickAscendingDropdown();
    }

    @Then("I check that sorting by name ascending is correct")
    public void checkingByNameAscending() {
        boolean isCorrect = productsPage.checkSortProductByNameAscending();
        softAssertions.assertThat(isCorrect).isEqualTo(true);
    }

    @Then("I sort products as 'Name, Z to A'")
    public void sortingProductByNameDescending() {
        productsPage.clickSortingButton();
        productsPage.clickDescendingDropdown();
    }

    @Then("I check that sorting by name descending is correct")
    public void checkingByNameDescending() {
        boolean isCorrect = productsPage.checkSortProductByNameDescending();
        softAssertions.assertThat(isCorrect).isEqualTo(true);
    }

    @Then("I sort products as 'Price, low to high'")
    public void sortingByPriceAscending() {
        boolean isCorrect = productsPage.checkSortProductByPriceAscending();
        softAssertions.assertThat(isCorrect).isEqualTo(true);
    }

    @Then("I check that sorting by Price ascending is correct")
    public void checkingByPriceAscending() {
        boolean isCorrect = productsPage.checkSortProductByPriceAscending();
        softAssertions.assertThat(isCorrect).isEqualTo(true);

    }
    @Then("I sort products as 'Price, high to low'")
    public void sortingByPriceDescending() {
        boolean isCorrect = productsPage.checkSortProductByPriceDescending();
        softAssertions.assertThat(isCorrect).isEqualTo(true);
    }

    @Then("I check that sorting by Price Descending is correct")
    public void checkingByPriceDescending() {
        boolean isCorrect = productsPage.checkSortProductByPriceDescending();
        softAssertions.assertThat(isCorrect).isEqualTo(true);
    }
}