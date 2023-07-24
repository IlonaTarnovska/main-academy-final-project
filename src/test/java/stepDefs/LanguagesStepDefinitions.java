package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.selenide.HomePage;


public class LanguagesStepDefinitions {

    HomePage homePage = new HomePage();

    @When("I should see {int} languages in the dropdown in the top menu")
    public void verifyLanguagesCount(int expectedCount) {
        int actualCount = homePage.getLanguagesCount();
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Then("I should see {string} language in the dropdown")
    public void verifyLanguageExists(String language) {
        boolean isLanguagePresent = homePage.isLanguagePresent(language);
        Assertions.assertThat(isLanguagePresent).isEqualTo(true);
    }
}
