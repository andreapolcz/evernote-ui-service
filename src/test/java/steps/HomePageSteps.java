package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pageObjects.HomePage;

/**
 * Created by andreapolcz on 6/26/17.
 */
public class HomePageSteps {


    private HomePage homepage = new HomePage();

    @Given("^user is on Evernote Homepage$")
    public void userIsOnEvernoteHomepage() {
        homepage.goToEverNote();
    }

    @And("^he opens Header Menu$")
    public void heOpensHeaderMenu() {
        homepage.openHeaderMenu();
    }

    @And("^he clicks sign in button$")
    public void heClicksSignInButton(){
        homepage.clickSignInButton();
    }



}
