package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MvMainPage extends Base {
    private By searchBar = By.xpath("//div[@class='input__container']/input");
    private By symbolSearch = By.xpath("//mvid-empty-srp-results");
    private By searchButton = By.xpath("//div[@class='search-icon-wrap ng-star-inserted']");
    private By goodsSearch = By.xpath("//p[contains(text(), 'Найден')]");
    private By promoSearch = By.xpath("//li[contains (text(), 'Промокоды на скидки')]");
    private By category = By.xpath("//div[@class='category-grid-wrapper']/h2");
    private By goodsAddToCart = By.xpath("//span[contains (text(), 'В корзину')]");
    private By symbolImage = By.xpath("//img[@class='empty-products__image']");
    private By promoAddToCart = By.xpath("//button[@value='Добавить в корзину']");

    //Поиск
    public void searchingItem(String keysToSend)
    {
        sendKey(searchBar, keysToSend);
    }

    public void sendEnterKey() {
        sendEnter(searchBar);
    }

    public void clickOnSearchButton() {
        clickOnTheButton(searchButton);
    }
    public void checkSearchResult(MvCasesSearchPage type, long time, String brandName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (type) {
            case BRAND: //Запросы по бренду. Пример: Samsung
                checkBrand(time, brandName);
                wait.until(ExpectedConditions.visibilityOfElementLocated(category)); //дизайн страниц брендов различный, но везде есть общий выбор по категориям
                break;
            case GOODS: //Запросы по виду товаров. Пример: Телевизоры
                wait.until(ExpectedConditions.visibilityOfElementLocated(goodsSearch));
                wait.until(ExpectedConditions.elementToBeClickable(goodsAddToCart));
                break;
            case SYMBOL: //Запросы по спец. символам. Пример: *
                wait.until(ExpectedConditions.visibilityOfElementLocated(symbolSearch));
                wait.until(ExpectedConditions.visibilityOfElementLocated(symbolImage));
                break;
            case PROMO: //Промо-страница при отправке пустой строки поиска
                wait.until(ExpectedConditions.visibilityOfElementLocated(promoSearch));
                wait.until(ExpectedConditions.elementToBeClickable(promoAddToCart));
        }
    }
    public void checkBrand(long time, String brandname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        String brandNameString = String.format("//li[contains(text(), 'Все товары бренда %s')]", brandname);
        By brandXpath = By.xpath(brandNameString);
        wait.until(ExpectedConditions.visibilityOfElementLocated(brandXpath));
    }

}





