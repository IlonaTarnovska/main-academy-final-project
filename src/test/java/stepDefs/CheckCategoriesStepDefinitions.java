package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.selenide.HomePage;

import java.util.Arrays;
import java.util.List;

public class CheckCategoriesStepDefinitions {

    //Test case #5 (Check categories)
    //
    // Go to the https://demo.prestashop.com/
    // Hover mouse over 'CLOTHES'
    // Check that 'MEN' and 'WOMEN' sub menu items appears
    // Hover mouse over 'ACCESSORIES'
    // Check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears
    // Hover mouse over 'ART'
    // Check that no any sub category appears

    HomePage homePage = new HomePage();

    @When("I hover mouse over 'CLOTHES'")
    public void hoverMouseClothes() {
        homePage.hoverMouseOnClothesButton();
    }

    @And("I check that 'MEN' and 'WOMEN' sub menu items appears")
    public void checkClothesItems() {
        List<String> actual = homePage.getClothesDropdownElement();
        List<String> expected = Arrays.asList("MEN", "WOMEN");

        Assertions.assertThatList(actual)
                .isEqualTo(expected);
    }

    @And("I hover mouse over 'ACCESSORIES'")
    public void hoverMouseAccessories() {
        homePage.hoverMouseOnAccessoriesButton();
    }

    @And("I check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears")
    public void checkAccessoriesItems() {
        List<String> actual = homePage.getAccessoriesDropdownElement();
        List<String> expected = Arrays.asList("STATIONERY", "HOME ACCESSORIES");

        Assertions.assertThatList(actual)
                .isEqualTo(expected);
    }

    @And("I hover mouse over 'ART'")
    public void hoverMouseArt() {
        homePage.hoverMouseOnArtButton();
    }

    @Then("I check that no any sub category appears")
    public void checkArtItems() {
        int actualSize = homePage.getArtDropdownElement().size();

        Assertions.assertThat(actualSize)
                .isEqualTo(0);
    }
}
