package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.WebDriverFactory;

import java.io.File;

public class MainPage extends Base {

  private static final By downloadBtn = By.cssSelector("a.js-download");
  private static final By photoSelect = By.cssSelector("article.photo-item");
  private static final By downloadPhoto =By.xpath("//span[contains(text(), 'Бесплатное')]");

  public void downloadClick() { //Нахождение кнопки скачать и клик по ней
    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(downloadBtn));
    input.click();
  }
  public void moveToPhoto() { //Движение курсора к элементу
    WebElement photo = wait.until(ExpectedConditions.visibilityOfElementLocated(photoSelect));
    Actions actions = new Actions(driver);
    actions.moveToElement(photo);
    actions.perform();
  }

  public void clickDownload() { //Нахождение кнопки скачать и клик по ней
    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(downloadPhoto));
    input.click();
  }


}
