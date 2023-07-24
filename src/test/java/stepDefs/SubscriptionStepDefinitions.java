package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.selenide.HomePage;

public class SubscriptionStepDefinitions {

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

}
