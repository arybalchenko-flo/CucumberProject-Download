package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MvMainPage extends Base {
    private final By searchBar = By.xpath("//div[@class='input__container']/input");
    private final By searchResult = By.xpath("//p[@class='srp-title ng-star-inserted']");

    //Поиск
    public void search(String keysToSend)
    {
        sendKey(searchBar, keysToSend);
    }

    public void sendEnterKey() {
        sendEnter(searchBar);
    }

    public void searchResultCheck() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        }
    }


