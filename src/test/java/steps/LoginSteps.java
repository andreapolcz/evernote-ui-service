package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObjects.LoginPage;

/**
 * Created by andreapolcz on 6/12/17.
 */

public class LoginSteps {


    public LoginPage loginPage = new LoginPage();

    @Then("^he is on login page$")
    public void heGoesToLoginPage() {
        loginPage.isUserOnLoginPage();
    }


    @And("^he enters his username \"([^\"]*)\"$")
    public void heEntersHisUsername(String userName) {
        loginPage.enterUserName(userName);
    }

    @And("^he hits the submit button$")
    public void heHitsTheSubmitButton() {
        loginPage.submitCredentials();
    }

    @And("^he enters his password \"([^\"]*)\"$")
    public void heEntersHisPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void messageIsDisplayed(String messageContent) {
        loginPage.verifyErrorMessage(messageContent);
    }
}
