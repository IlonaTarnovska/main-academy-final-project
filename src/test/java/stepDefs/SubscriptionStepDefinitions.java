package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.selenide.HomePage;

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

        Assertions.assertThat(label)
                .as("Expected label " + expectedLabel)
                .isEqualTo(expectedLabel);
    }

    @Then("I check subscription message {string}")
    public void iCheckSubscriptionMessage(String expectedMessage) {
        String message = homePage.getUnsubscribeMessage();

        Assertions.assertThat(message)
                .as("Expected message " + expectedMessage)
                .isEqualTo(expectedMessage);
    }

    @Then("I check that all characters on SUBSCRIBE button in upper case")
    public void iCheckThatAllCharactersOnButtonInUpperCase() {
        Assertions.assertThat(homePage.checkUpperCase())
                .isEqualTo(true);
    }
}
