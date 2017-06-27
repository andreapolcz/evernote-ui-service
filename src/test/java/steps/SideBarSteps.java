package steps;

import components.SideBar;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by andreapolcz on 6/26/17.
 */
public class SideBarSteps {

    private SideBar sideBar = new SideBar();

    @Then("^opens user details by clicking on avatar icon$")
    public void opensUserDetailsByClickingOnAvatarIcon() {
        sideBar.clickUserAvatar();
    }

    @Then("^displayed userName is \"([^\"]*)\"$")
    public void displayedUserNameIs(String userName) {
        sideBar.verifyUserName(userName);
    }


    @And("^user logs out$")
    public void userLogsOut() {
        sideBar.logout();
    }
}
