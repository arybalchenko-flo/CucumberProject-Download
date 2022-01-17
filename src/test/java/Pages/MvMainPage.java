package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MvMainPage extends Base {
    private By searchBar = By.xpath("//div[@class='input__container']/input");
    private By symbolSearch = By.xpath("//mvid-empty-srp-results");
    private By brandSearch = By.xpath("//li[contains(text(), 'Все товары бренда')]");
    private By goodsSearch = By.xpath("//p[contains(text(), 'Найдено')]");
    private By promoSearch = By.xpath("//li[contains (text(), 'Узкие стиральные машины Bosch')]");

    //Поиск
    public void searchingItem(String keysToSend)
    {
        sendKey(searchBar, keysToSend);
    }

    public void sendEnterKey() {
        sendEnter(searchBar);
    }

    public void checkSearchResult(MvCasesSearchPage type, long time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (type) {
            case BRAND: //Запросы по бренду. Пример: Samsung
                wait.until(ExpectedConditions.visibilityOfElementLocated(brandSearch));
                break;
            case GOODS: //Запросы по виду товаров. Пример: Телевизоры
                wait.until(ExpectedConditions.visibilityOfElementLocated(goodsSearch));
                break;
            case SYMBOL: //Запросы по спец. символам. Пример: *
                wait.until(ExpectedConditions.visibilityOfElementLocated(symbolSearch));
                break;
            case PROMO: //Промо-страница при отправке пустой строки поиска
                wait.until(ExpectedConditions.visibilityOfElementLocated(promoSearch));
        }
    }
}





