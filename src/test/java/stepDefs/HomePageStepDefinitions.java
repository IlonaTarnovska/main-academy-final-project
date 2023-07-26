package stepDefs;

import io.cucumber.java.en.Given;
import org.selenide.HomePage;

public class HomePageStepDefinitions {

    HomePage homePage = new HomePage();

    @Given("I am on the home page")
    public void iAmOnTheMainPage() {
        homePage.openHomePage();
    }

}
