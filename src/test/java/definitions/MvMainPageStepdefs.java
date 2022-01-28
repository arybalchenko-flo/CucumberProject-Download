package definitions;

import Base.Base;
import Pages.MvCasesSearchPage;
import Pages.MvMainPage;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MvMainPageStepdefs extends Base {
    MvMainPage main = new MvMainPage();

    @When("I open the {string} site page")
    public void iOpenTheSitePage(String siteUrl) {
        Hooks.openSite(siteUrl);
    }

    @Then("Page {string} opened")
    public void pageOpened(String url) {
        waitForUrlContains(url);
        waitForSiteToLoad();
    }

    @When("Searching item {string}")
    public void searchingItem(String keysToSend) {
        main.searchingItem(keysToSend);
    }

    @Then("Search of {string} {string} completed")
    public void searchOfCompleted(String type, String brandName) {
        main.checkSearchResult(MvCasesSearchPage.valueOf(type), 8, brandName);
    }

    @And("click enter")
    public void clickEnter() {
        main.sendEnterKey();
    }

    @And("click on the search button")
    public void clickOnTheSearchButton() {
        main.clickOnSearchButton();
    }


}
