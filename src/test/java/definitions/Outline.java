package definitions;

import Base.Base;
import Pages.MainPage;
import Pages.MvMainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Outline extends Base {
    MvMainPage main = new MvMainPage();

    @When("I search {string}")
    public void iSearch(String keysToSend) {
        main.search(keysToSend);
        main.sendEnterKey();
        main.searchResultCheck();
    }

    @Then("Search {string} completed")
    public void searchCompleted(String keysToSend) {
        System.out.println("Search " + keysToSend + " completed.");
    }
}
