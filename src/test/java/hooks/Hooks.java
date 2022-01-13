package hooks;

import Base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.Browsers;
import util.WebDriverFactory;
import variables.Variables;

import java.io.File;

public class Hooks extends Base {
    @Before (order = 1)
    public static void setup() {
        driver = WebDriverFactory.getDriver(Variables.browser);
        driver.manage().window().maximize();
        if (Variables.browser == Browsers.CHROME_WIN) {
            File f = new File(WebDriverFactory.downloadDirWin);
            f.mkdir();
        }
        if (Variables.browser == Browsers.CHROME_MAC) {
            File f = new File(WebDriverFactory.downloadDirMac);
            f.mkdir();
        }
    }

    @After (order = 1)
    public static void quit() {
        driver.quit();
        System.out.println("Test ended");
    }
    public static void openSite(String siteUrl) {
        driver.get(siteUrl); //открыть сайт;
    }
}
