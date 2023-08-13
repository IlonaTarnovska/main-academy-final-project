package stepDefs;

import io.cucumber.java.en.And;
import org.selenide.RegisterPage;

import static stepDefs.HomePageStepDefinitions.softAssertions;

public class RegistrationInvalidDataStepDefinitions {

// Test case #4 (Registration with invalid data)
//
//  Go to the https://demo.prestashop.com/
//  Click on 'Sign in' button at the right corner of the page
//  Click on 'No account? Create one here' link
//  Fill 'First name' field with 'James8'
//  Fill the rest fields valid data
//  Check that 'First name' higlighted in red
//  Check that pop-up with text 'Invalid format.' appear under field

    private final RegisterPage registerPage = new RegisterPage();

    @And("I fill the form with invalid data")
    public void fillRegistrationFormInvalid() {
        registerPage.fillRegistrationData(
                "James8",
                "Doe",
                "johndoe@example.com",
                "AbRaCaDaBrA69$$$@"
        );
    }

    @And("I check that 'First name' highlighted in red")
    public void checkHighlightedName(){
        String color = registerPage.getNameOutlineColor();
        softAssertions.assertThat(color)
                .isEqualTo("rgba(255, 76, 76, 1)");
    }

    @And("I check that pop-up with text 'Invalid format.' appear under field")
    public void checkPopUpMessage(){
        softAssertions.assertThat(registerPage.isPopUpMessageAppears())
                .isEqualTo(true);
    }
}