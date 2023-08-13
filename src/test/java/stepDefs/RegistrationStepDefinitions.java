package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenide.HomePage;
import org.selenide.LoginPage;
import org.selenide.RegisterPage;

import static stepDefs.HomePageStepDefinitions.softAssertions;

public class RegistrationStepDefinitions {

    // Test case #3 (Registration with valid data)
    //
    // Go to the https://demo.prestashop.com/
    // Click on 'Sign in' button at the right corner of the page
    // Click on 'No account? Create one here' link
    // Fill the form with valid data
    // Click on 'Save' button
    // Check your name appear near cart button

    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();

    @When("I click on 'Sign in' button at the right corner of the page")
    public void clickSignInButton() {
        homePage.clickSignInButton();
    }

    @And("I click on 'No account? Create one here' link")
    public void clickRegistrationButton() {
        loginPage.clickRegistrationButton();
    }

    @And("I fill the form with valid data")
    public void fillRegistrationForm() {
        registerPage.fillRegistrationData(
                "John",
                "Doe",
                "johndoe@example.com",
                "AbRaCaDaBrA69$$$@"
        );
    }

    @And("I click on 'Save' button")
    public void clickSaveButton() {
        registerPage.clickSaveButton();
    }

    @Then("I should see my name appear near the cart button")
    public void verifyNameAppearsNearCartButton() {
        String expectedName = "John Doe";
        String actualName = homePage.getLoggedInUserName();

        softAssertions.assertThat(actualName).isEqualTo(expectedName);
    }
}
