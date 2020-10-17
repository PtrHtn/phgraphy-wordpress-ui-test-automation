package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
}
