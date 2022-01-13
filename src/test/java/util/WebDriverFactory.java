package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class WebDriverFactory {
    public static String downloadDirMac = System.getProperty("user.dir") + "//src//test//downloads";
    public static String downloadDirWin = System.getProperty("user.dir") + "\\src\\test\\downloads";
    public static WebDriver getDriver(Browsers browserType) {
        WebDriver driver = null;
        switch (browserType) {
            case CHROME_MAC:
                WebDriverManager.chromedriver().setup();
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("download.default_directory", downloadDirMac);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(options);
                break;
            case CHROME_WIN:
                WebDriverManager.chromedriver().setup();
                HashMap<String, Object> chromePrefsWin = new HashMap<String, Object>();
                chromePrefsWin.put("download.default_directory", downloadDirWin);
                ChromeOptions optionsWin = new ChromeOptions();
                optionsWin.setExperimentalOption("prefs", chromePrefsWin);
                driver = new ChromeDriver(optionsWin);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME_CLEAR:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
        return driver;
    }
}
