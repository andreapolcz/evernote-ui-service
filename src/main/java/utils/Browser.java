package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by andreapolcz on 6/12/17.
 */

public class Browser {

    private static volatile WebDriver driver = null;
    private static final String chromeDriverWindows = "/chromedriver.exe";
    private static final String chromeDriverMacOS = "/chromedriver";
    private static final String MAC_OS_X = "Mac OS X";
    private static final String WINDOWS_10 = "Windows 10";

    private Browser() {
    }

    private static final Log LOG = LogFactory.getLog(Browser.class);


    /**
     * Will instantiate a new driver object, taken in consideration the operating system
     * the tests will run on
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (Browser.class) {
                if (driver == null) {
                    String osname = System.getProperty("os.name");
                    if (osname.equals(MAC_OS_X)) {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverMacOS);
                    } else if (osname.equals(WINDOWS_10)) {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverWindows);
                    }
                }
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
}
