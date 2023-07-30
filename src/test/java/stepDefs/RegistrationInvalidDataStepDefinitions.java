package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.selenide.HomePage;
import org.selenide.LoginPage;
import org.selenide.RegisterPage;

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
        Assertions.assertThat(color)
                .isEqualTo("rgba(255, 76, 76, 1)");
    }

    @And("I check that pop-up with text 'Invalid format.' appear under field")
    public void checkPopUpMessage(){
        Assertions.assertThat(registerPage.isPopUpMessageAppears())
                .isEqualTo(true);
    }
}