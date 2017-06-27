package pageObjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.Constants;
import utils.PageActions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by andreapolcz on 6/26/17.
 */
public class LoginPage extends PageActions {

    private final String EXPECTED_URL_VALUE = "Login";
    private String loginPage = "https://www.evernote.com/Login.action";
    private String usernameFieldLocator = "username";
    private String passwordFieldLocator = "password";
    private String submitCredentialsButton = "loginButton";
    private String responseMessage = "responseMessage";

    private static final Log LOG = LogFactory.getLog(LoginPage.class);

    /**
     * will verify if user is on wanted page (login), if not, selenium will redirect to login page
     * - i implemented it this way, because it opened differently (2 different ways) each time
     *  ran the tests. I didn't have more time to analyze why (it may be because of the screen resolution)
     */
    public void isUserOnLoginPage() {
        try {
            Assert.assertEquals("User not on login page",getUrl().contains(EXPECTED_URL_VALUE), true);
        }catch(AssertionError e ){
            LOG.error(e);
            navigation(loginPage);
        }
    }


    /**
     * Will click login button
     */
    public void submitCredentials() {
        click(By.id(submitCredentialsButton));
    }

    /**
     * Will input username in proper field
     *
     * @param userName - username value
     */
    public void enterUserName(String userName) {
        waitByElementsDisplayed(By.id(usernameFieldLocator), Constants.SECONDS_TO_WAIT_10);
        click(By.id(usernameFieldLocator));
        typeText(By.id(usernameFieldLocator), userName);
    }

    /**
     * Will input username in proper field
     *
     * @param password - username value
     */
    public void enterPassword(String password) {
        waitByElementsDisplayed(By.id(passwordFieldLocator), Constants.SECONDS_TO_WAIT_10);
        click(By.id(passwordFieldLocator));
        typeText(By.id(passwordFieldLocator), password);
    }

    /**
     * verifies incorrect error message for submitting  empty credential field
     */
    public void verifyErrorMessage(String expectedMessage) {
        waitForTextToBeDisplayed(By.id(responseMessage), Constants.SECONDS_TO_WAIT_10);
        String actualMessage = getText(By.id(responseMessage));
        assertThat(actualMessage, is(expectedMessage));
    }
}
