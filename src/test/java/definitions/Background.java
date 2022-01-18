package definitions;

import Base.Base;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Background extends Base {
    @When("I open the {string} site page")
    public void iOpenTheSitePage(String siteUrl) {
        Hooks.openSite(siteUrl);
    }

    @Then("Page {string} opened")
    public void pageOpened(String url) {
        waitForUrlContains(url);
    }
}
