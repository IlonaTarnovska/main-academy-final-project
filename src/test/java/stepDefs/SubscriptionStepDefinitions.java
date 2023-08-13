package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenide.HomePage;

import static stepDefs.HomePageStepDefinitions.softAssertions;

public class SubscriptionStepDefinitions {

    //Test case #1 (Subscribe with invalid email)
    //
    // Go to the https://demo.prestashop.com/
    // On the buttom of the page check that text near the email field equals 'Get our latest news and special sales'
    // On the buttom of the page check that text under email field contains 'You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.'
    // Check that all characters on 'SUBSCRIBE' button in upper case

    HomePage homePage = new HomePage();

    @When("I check subscription label {string}")
    public void iCheckSubscriptionLabel(String expectedLabel) {
        String label = homePage.getNewsLetterLabelText();

        softAssertions.assertThat(label)
                .as("Expected label " + expectedLabel)
                .isEqualTo(expectedLabel);
    }

    @Then("I check subscription message {string}")
    public void iCheckSubscriptionMessage(String expectedMessage) {
        String message = homePage.getUnsubscribeMessage();

        softAssertions.assertThat(message)
                .as("Expected message " + expectedMessage)
                .isEqualTo(expectedMessage);
    }

    @Then("I check that all characters on SUBSCRIBE button in upper case")
    public void iCheckThatAllCharactersOnButtonInUpperCase() {
        softAssertions.assertThat(homePage.checkUpperCase())
                .isEqualTo(true);
    }
}
