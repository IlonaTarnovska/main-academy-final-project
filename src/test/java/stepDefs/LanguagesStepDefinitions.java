package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenide.HomePage;

import java.util.List;

import static stepDefs.HomePageStepDefinitions.softAssertions;


public class LanguagesStepDefinitions {

    HomePage homePage = new HomePage();

    @When("I should see {int} languages in the dropdown in the top menu")
    public void verifyLanguagesCount(int expectedCount) {
        int actualCount = homePage.getLanguagesCount();

        softAssertions.assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Then("I should see {string} language in the dropdown")
    public void verifyLanguageExists(String language) {
        List<String> languages = homePage.getLanguages();

        softAssertions.assertThat(languages).contains(language);
    }
}
