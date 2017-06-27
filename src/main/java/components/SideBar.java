package components;

import org.openqa.selenium.By;
import utils.Constants;
import utils.PageActions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Created by andreapolcz on 6/26/17.
 */
public class SideBar extends PageActions {

    private String avatarIconLocator = "//div[contains(@id,'avatar')]//img[contains(@src,'user')]";
    private String accountName = "//div[contains(@id,'AccountMenu-name')]";
    private String logoutButton = "//div[contains(@id,'logout')]";


    /**
     *  opens user account menu popup
     */
    public void clickUserAvatar() {
        waitByElementsDisplayed(By.xpath(avatarIconLocator), Constants.SECONDS_TO_WAIT_10);
        click(By.xpath(avatarIconLocator));
    }

    /**
     * verifies displayed user name in avatar popup
     */
    public void verifyUserName(String userName){
        waitByElementsDisplayed(By.xpath(accountName), Constants.SECONDS_TO_WAIT_10);
        assertThat(userName.toUpperCase(), is(getText(By.xpath(accountName))));
    }

    /**
     * clicks logout button from account menu popup
     */
    public void logout() {
        click(By.xpath(logoutButton));
    }
}
