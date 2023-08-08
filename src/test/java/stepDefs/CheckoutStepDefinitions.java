package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.selenide.HomePage;
import org.selenide.ProductDetailsPage;
import org.selenide.SearchResultsPage;
import org.selenide.ShoppingCartPage;

public class CheckoutStepDefinitions {

    //Test case #10 (Checkout end-to-end)
    //
    // Go to the https://demo.prestashop.com/
    // In the search field enter 'Mug' and press 'Enter'
    // On the 'SEARCH RESULTS' page click on 'Customizable Mug'
    // Enter 'Best mug ever' in 'Product customization' field
    // Click 'SAVE CUSTOMIZATION'
    // Change 'Quantity' to '1' if not '1' already
    // Click 'ADD TO CART' button
    // On the next window click 'CONTINUE SHOPPING'
    // In the search field enter 'T-Shirt' and press 'Enter'
    // On the 'SEARCH RESULTS' page click on 'Hummingbird Printed T-Shirt'
    // Select 'Black' color
    // Click 'ADD TO CART' button
    // On the next window click 'PROCEED TO CHECKOUT'
    // On the 'SHOPPING CART' page check that 'Total' calculated correct
    // Click 'PROCEED TO CHECKOUT'
    // Fill 'PERSONAL INFORMATION' form with valid data (without password)
    // Check all necessary checkboxes
    // Click 'CONTINUE'
    // Fill the 'ADDRESSES' form with valid data
    // Click 'CONTINUE'
    // On the 'SHIPPING METHOD' section select 'My carrier'
    // Click 'CONTINUE'
    // On the 'PAYMENT' section select 'Pay by Check'
    // Check that Amount equal Subtotal+Shipping
    // Click on 'I agree..' checkbox
    // Click on 'Order with an obligation to pay'
    // Check that 'YOUR ORDER IS CONFIRMED' appered on the next page
    // Check that 'TOTAL' calculated correct

    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    SoftAssertions softAssertions = new SoftAssertions();

    @When("I enter {string} in the search field and press 'Enter'")
    public void searchItem(String text) {
        homePage.fillSearchField(text);
        homePage.enterSearchField();
    }


    @Then("I enter {string} in 'Product customization' field")
    public void fillCustomizationField(String text) {
        productDetailsPage.fillCustomizeField(text);
    }

    @Then("I click 'SAVE CUSTOMIZATION'")
    public void clickOnSaveCustomization (){
        productDetailsPage.clickOnSaveCustomizationButton();
    }

    @Then("I change 'Quantity' to {string} if not '1' already")
    public void setQuantity(String quantity){
        productDetailsPage.setQuantity(quantity);
    }

    @Then("I click 'ADD TO CART' button")
    public void clickAddToCartButton(){
        productDetailsPage.clickAddToCartButton();
    }

    @Then("I click 'CONTINUE SHOPPING'")
    public void clickOnContinueShoppingButton(){
        productDetailsPage.clickOnContinueShoppingButton();
    }

    @Then("I select 'Black' color")
    public void selectColor(){
        productDetailsPage.clickOnColorSelectorBlack();
    }

    @Then("I click 'PROCEED TO CHECKOUT'")
    public void clickProceedToCheckoutButton(){
        productDetailsPage.clickOnModalProceedToCheckoutButton();
    }

    @Then("On the 'SHOPPING CART' page I check that 'Total' calculated correct")
    public void checkTotalIsCorrect(){
        Float actual = shoppingCartPage.getTotalPrice();
        Float expected = shoppingCartPage.getCalculatedTotalPrice();

        softAssertions.assertThat(actual).isEqualTo(expected);
    }
}
