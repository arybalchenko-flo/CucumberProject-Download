package definitions;

import Base.Base;
import Pages.MainPage;
import Pages.MvCasesSearchPage;
import Pages.MvMainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Outline extends Base {
    MvMainPage main = new MvMainPage();

    @When("I search item {string}")
    public void iSearchItem(String keysToSend) {
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
