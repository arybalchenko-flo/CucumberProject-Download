package definitions;

import Base.Base;
import Pages.MainPage;
import Pages.MvCasesSearchPage;
import Pages.MvMainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Outline extends Base {
    MvMainPage main = new MvMainPage();

    @When("I search item {string}")
    public void iSearchItem(String keysToSend) {
        main.searchingItem(keysToSend);
        main.sendEnterKey();
    }

    @Then("Search of {string} completed")
    public void searchOfCompleted(String type) {
        main.checkSearchResult(MvCasesSearchPage.valueOf(type), 8);
    }
}
