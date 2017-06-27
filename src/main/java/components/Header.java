package components;

import org.openqa.selenium.By;
import utils.Constants;
import utils.PageActions;

/**
 * Created by andreapolcz on 6/27/17.
 */
public class Header extends PageActions {

    private String doneButton = "//button[contains(@id,'doneButton')]";


    /**
     *  switches to default Frame (in case the user was in another frame before)
     *  hits done, in order to finnish editing notes
     */
    public void clickDoneButton() {
        switchToDefaultFrame();
        waitForTextToBeDisplayed(By.xpath(doneButton), Constants.SECONDS_TO_WAIT_10);
        click(By.xpath(doneButton));
    }
}
