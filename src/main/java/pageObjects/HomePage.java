package pageObjects;

import utils.Constants;
import utils.PageActions;
import org.openqa.selenium.By;

/**
 * Created by andreapolcz on 6/12/17.
 */
public class HomePage extends PageActions {

    private String baseUrl = "https://evernote.com/";
    private String headerMenuLocator = "//a[@id='header-menu']/span[@class='header-sprite']";
    private String signInButtonLocator = "//a[contains(@class,'sign-in-menu')]";
    private int windowWidth = 1201;
    private int windowHeight = 768;


    /**
     * Will open home page for Evernote
     */
    public void goToEverNote() {
        navigation(baseUrl);
        windowSize(windowWidth, windowHeight);
    }

    /**
     * Will open navigation menu
     */
    public void openHeaderMenu() {
        waitByElementsDisplayed(By.xpath(headerMenuLocator), Constants.SECONDS_TO_WAIT_10);
        click(By.xpath(headerMenuLocator));
    }

    /**
     * Will navigate to Login In Page
     */
    public void clickSignInButton() {
        waitByElementsDisplayed(By.xpath(signInButtonLocator), Constants.SECONDS_TO_WAIT_10);
        click(By.xpath(signInButtonLocator));
    }
}
