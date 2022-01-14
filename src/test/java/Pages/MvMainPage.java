package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MvMainPage extends Base {
    private By searchBar = By.xpath("//div[@class='input__container']/input");
    private By noSearchResults = By.xpath("//mvid-empty-srp-results");

    //Поиск
    public void searchingItem(String keysToSend)
    {
        sendKey(searchBar, keysToSend);
    }

    public void sendEnterKey() {
        sendEnter(searchBar);
    }

    public boolean isElementPresent(long time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time)); // you can set the wait time in second
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated((noSearchResults)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}





