package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenide.HomePage;
import org.selenide.ProductDetailsPage;
import org.selenide.SearchResultsPage;

import static stepDefs.HomePageStepDefinitions.softAssertions;


public class AddingToCartStepDefinitions {

    //Test case #9 (Adding to cart)
    //
    // Go to the https://demo.prestashop.com/
    // In the search field enter 'Bear' and press 'Enter'
    // On the 'SEARCH RESULTS' page click on 'Brown Bear Notebook'
    // Change 'Paper type' to 'Doted'
    // Change 'Quantity' to '5'
    // Click 'ADD TO CART' button
    // Check that new window with title 'Product successfully added to your shopping cart' appears
    // Check that correct 'Paper Type' and 'Quantity' is shown on the left side of the window
    // Check that 'Total' calculated correct

    HomePage homePage = new HomePage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @When("In the search field I enter {string} and press 'Enter'")
    public void searchItem(String text) {
        homePage.fillSearchField(text);
        homePage.enterSearchField();
    }

    @Then("On the 'SEARCH RESULTS' page I click on {string}")
    public void clickOnTheItem(String productName) {
        searchResultsPage.clickOnProductWithText(productName);
    }

    @Then("I change 'Paper type' to {string}")
    public void changePaperType(String text) {
        productDetailsPage.paperTypeDropdownClick(text);
    }

    @Then("I change 'Quantity' to {string}")
    public void changeQuantityType(String quantity) {
        productDetailsPage.setQuantity(quantity);
    }

    @Then("I click on 'ADD TO CART' button")
    public void clickOnAddToCartButton(){
        productDetailsPage.clickAddToCartButton();
    }

    @Then("I check that new window with title {string} appears")
    public void checkModalWindowTitle(String title){
        String actual = productDetailsPage.getModalWindowTitle();

        softAssertions.assertThat(actual).isEqualTo(title);
    }

    @Then("I check that correct 'Paper Type' {string} and 'Quantity' {string} is shown on the left side of the window")
    public void checkIfOrderIsCorrect(String paperType, String quantity){
        String actualPaperType = productDetailsPage.modalWindowPaperType();
        softAssertions.assertThat(actualPaperType).isEqualTo(paperType);

        String actualQuantity = productDetailsPage.modalWindowQuantity();
        softAssertions.assertThat(actualQuantity).isEqualTo(quantity);
    }

    @And("I check that 'Total' calculated correct")
    public void checkTotalPrice(){
        Float actualSubtotal = productDetailsPage.modalSubtotal();
        Float calculatedSubtotal = productDetailsPage.modalCalculatedSubtotal();

        softAssertions.assertThat(actualSubtotal).isEqualTo(calculatedSubtotal);
    }
}