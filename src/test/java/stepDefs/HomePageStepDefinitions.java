package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.assertj.core.api.SoftAssertions;
import org.selenide.HomePage;

public class HomePageStepDefinitions {

    public static SoftAssertions softAssertions = new SoftAssertions();

    HomePage homePage = new HomePage();

    @Given("I am on the home page")
    public void iAmOnTheMainPage() {
        homePage.openHomePage();
    }

    @And("I check all assertions")
    public void checkAssertions() {
        softAssertions.assertAll();
    }

}
