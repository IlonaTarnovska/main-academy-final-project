package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
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

    @When("I click on the 'All products >' under the 'POPULAR PRODUCTS' section")
    public void clickOnAllProductsLink() {
        homePage.clickAllProductsLink();
    }

    @Then("I sort products as 'Name, A to Z'")
    public void sortingProductByNameAscending(){
        productsPage.clickSortingButton();
        productsPage.clickAscendingDropdown();
    }

    @Then("I check that sorting by name ascending is correct")
    public void checkingByNameAscending(){
        boolean isCorrect = productsPage.checkSortProductByNameAscending();
        Assertions.assertThat(isCorrect).isEqualTo(true);
    }


}
