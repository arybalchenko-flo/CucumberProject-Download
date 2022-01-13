package hooks;

import Base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.Browsers;
import util.WebDriverFactory;
import variables.Variables;

public class Hooks extends Base {
    @Before (order = 1)
    public static void setup() {
        driver = WebDriverFactory.getDriver(Browsers.CHROME_WIN);
        driver.manage().window().maximize();
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
