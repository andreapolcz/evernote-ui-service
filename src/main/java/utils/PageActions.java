package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by andreapolcz on 6/12/17.
 */
public class PageActions {

    private  static final String JAVASCRIPT_ARGUMENT_CLICK = "arguments[0].click();";
    private static final Log LOG = LogFactory.getLog(PageActions.class);

    private  static List<WebElement> reconstructWebElements(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        List<WebElement> elements = Browser.getDriver().findElements(locator);
        for (WebElement element : elements) {
            element.click();
        }

    }

    protected void clickWithJs(By locator) {
        List<WebElement> elements = Browser.getDriver().findElements(locator);
        final JavascriptExecutor executor = (JavascriptExecutor) Browser
                .getDriver();
        for (WebElement element : elements) {
            executor.executeScript(JAVASCRIPT_ARGUMENT_CLICK, element);
        }
    }

    protected Dimension setWindowSize() {
        return Browser.getDriver().manage().window().getSize();
    }

    protected void clickByText(By locator, String wantedValue) {
        waitByElementsDisplayed(locator, Constants.SECONDS_TO_WAIT_10);
        List<WebElement> elements = Browser.getDriver().findElements(locator);
        for (WebElement element : elements) {
            if (element.getText().equals(wantedValue)) {
                element.click();
                break;
            }
        }
    }

    protected void typeText(By locator, String textToSend) {
        Browser.getDriver().findElement(locator).sendKeys(textToSend);
    }

    protected void deleteText(By locator) {
        Browser.getDriver().findElement(locator).clear();
    }

    protected String getText(By locator) {
        return Browser.getDriver().findElement(locator).getText();
    }

    protected List<String> getTextFromSeveral(By locator) {
        waitByElementsDisplayed(locator, Constants.SECONDS_TO_WAIT_10);
        List<String> values = new ArrayList<String>();
        List<WebElement> elements = Browser.getDriver().findElements(locator);
        for (WebElement element : elements) {
            scrollIntoView(element);
            values.add(element.getText());
        }
        return values;
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void navigation(String url) {
        Browser.getDriver().navigate().to(url);
    }

    protected String getUrl() {
        return Browser.getDriver().getCurrentUrl();

    }

    protected void waitByElementsDisplayed(By locator, int secondsToCheck) {
        for (int i = 1; i < secondsToCheck; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOG.info(e);
            }
            if (getListSize(locator) > 0) {
                break;
            }
        }
    }

    protected void waitForTextToBeDisplayed(By locator, int secondsToCheck) {
        int iterator = secondsToCheck;
        int size;
        String text = "";
        List<WebElement> elements;
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOG.error(e);
            }
            iterator--;
            elements = reconstructWebElements(Browser.getDriver(), locator);
            Browser.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            if (elements.size() == 1) {
                text = elements.get(0).getText();
            }
        } while (iterator > 0 && text.equals(""));
        if (iterator == 0) {
            LOG.info(Constants.FAILED_LOADING_ERROR_MESSAGE);

        }
    }

    protected void windowSize(int windowWidth, int windowHeight) {
        boolean maximizeWindow = (windowWidth == 1) && (windowHeight == 1);
        if (maximizeWindow) {
            Browser.getDriver().manage().window().maximize();
        } else {
            Browser.getDriver().manage().window().setSize(new Dimension(windowWidth, windowHeight));
        }
    }

    protected void pressKey(Keys keyToPress) {
        Actions actions = new Actions(Browser.getDriver());
        actions.sendKeys(keyToPress);
        actions.build().perform();
    }

    protected int getListSize(final By locator) {
        List<WebElement> elements = Browser.getDriver().findElements(locator);
        return elements.size();
    }

    protected void switchToFrame(String frameLocator) {
        Browser.getDriver().switchTo().frame(Browser.getDriver().findElement(By.xpath(frameLocator)));
    }

    protected void switchToDefaultFrame() {
        Browser.getDriver().switchTo().defaultContent();
    }
}

