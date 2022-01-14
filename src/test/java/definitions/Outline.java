package definitions;

import Base.Base;
import Pages.MainPage;
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

    @Then("Search completed")
    public void searchCompleted() {
        if (!main.isElementPresent(3)) {
            System.out.println("Items found");
        }
        else {
            System.out.println("Item not found");
        }
    }
}
