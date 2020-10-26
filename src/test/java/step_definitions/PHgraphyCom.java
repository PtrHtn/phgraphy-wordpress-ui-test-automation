package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.User;

public class PHgraphyCom  extends User {
    @Given("user is on the homepage of phgraphy.com website")
    public void userIsOnTheHomepageOfPhgraphyComWebsite() {
            user().navigateTo("https://phgraphy.com/");
    }

    @Then("header image is displayed on the top of page")
    public void headerImageIsDisplayedOnTheTopOfPage() {
        user().canSeeHeaderImage();
    }

    @When("user is on the homepage for the first time")
    public void userIsOnTheHomepageForTheFirstTime() {
    }

    @Then("Cookie Policy bar is displayed on the bottom of the page")
    public void cookiePolicyBarIsDisplayedOnTheBottomOfThePage() {
        user().canSeeCookiePolicyBar();
    }

    @And("contains text {string}")
    public void containsText(String cookiePolicyText) {
        user().canSeeCookiePolicyText(cookiePolicyText);
    }

    @When("user clicks button Close and accept")
    public void userClicksButtonCloseAndAccept() {
        user().clickButtonCloseAndAccept();
    }

    @Then("Cookie Policy bar is not displayed")
    public void cookiePolicyBarIsDisplayedNoMore() {
        user().canNotSeeCookiePolicyBar();
    }

    @When("user clicks on the first image")
    public void userClicksOnTheFirstImage() {
    }

    @Then("first image is displayed in higher resolution")
    public void firstImageIsDisplayedInHigherResolution() {
    }
}
