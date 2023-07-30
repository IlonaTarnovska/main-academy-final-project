package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.selenide.HomePage;

import java.util.Arrays;
import java.util.List;

public class CheckCategoriesStepDefinitions {

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

    @When("I hover mouse over 'ACCESSORIES'")
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

    @When("I hover mouse over 'ART'")
    public void hoverMouseArt() {
        homePage.hoverMouseOnArtButton();
    }

    @And("I check that no any sub category appears")
    public void checkArtItems() {
        int actualSize = homePage.getArtDropdownElement().size();

        Assertions.assertThat(actualSize)
                .isEqualTo(0);
    }
}
