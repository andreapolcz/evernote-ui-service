package pageObjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import utils.Constants;
import utils.PageActions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by andreapolcz on 6/27/17.
 */
public class NotesPage extends PageActions {

    private static final Log LOG = LogFactory.getLog(PageActions.class);
    private String addNewNoteButton = "(//div[contains(@id,'newNoteButton-container')]//img)[2]";
    private String noteTitleLocator = "//input[contains(@id,'NoteTitle')]";
    private String deleteNoteButton = "//div[contains(@id,'trash')]";
    private String confirmDeleteItem = "//span[contains(@id,'ConfirmationDialog-confirm')]";
    private String rowsInTable = "//table[contains(@style,'evernote')]//tr";
    private String noteContentFrame = "//iframe[contains(@id,'common-editor-iframe')]";


    /**
     * returns the cell that has to be selected in order to have a rowNumber * columnNumber matrix
     * @param rowNumber -  number of rows that the table should have
     * @param columnNumber - number of columns that the table should have
     */
    private String getTableCellLocator(int rowNumber, int columnNumber) {
        return "((//div[contains(@id,'tablePopup')]/div/div/div)[" + rowNumber + "]//div[contains(@class,'col')])[" + columnNumber + "]";
    }

    /**
     * opens new note edit zone
     */
    public void clickAddNewNote() {
        waitByElementsDisplayed(By.xpath(addNewNoteButton), Constants.SECONDS_TO_WAIT_10);
        click(By.xpath(addNewNoteButton));
    }

    /**
     * enters note title
     * @param noteTitle -  note title
     */
    public void putNoteTitle(String noteTitle) {
        waitForTextToBeDisplayed(By.xpath(noteTitleLocator), Constants.SECONDS_TO_WAIT_10);
        deleteText(By.xpath(noteTitleLocator));
        click(By.xpath(noteTitleLocator));
        typeText(By.xpath(noteTitleLocator), noteTitle);
        pressKey(Keys.ENTER);
    }

    /**
     * opens wanted note from the right area (existing notes area)
     * @param noteTitle -  note title
     */
    public void openNoteByTitle(String noteTitle) {
        try {
            waitForTextToBeDisplayed(By.xpath(getNoteByTitleLocator(noteTitle)), Constants.SECONDS_TO_WAIT_10);
            click(By.xpath(getNoteByTitleLocator(noteTitle)));
        } catch (NoSuchElementException e) {
            LOG.error("No such element:", e);
            Assert.fail();
        }
    }

    /**
     * deletes selected note
     */
    public void deleteSelectedNote() {
        click(By.xpath(deleteNoteButton));
        waitForTextToBeDisplayed(By.xpath(confirmDeleteItem), Constants.SECONDS_TO_WAIT_10);
        click(By.xpath(confirmDeleteItem));
    }

    /**
     * when in edit note mode, user has a variety of buttons on top of the note editor
     * @param buttonName - should a string that represents the id of the button element retrieved from DOM
     */
    public void clickButton(String buttonName) {
        waitByElementsDisplayed(By.xpath(getButtonInNotesHeader(buttonName)), Constants.SECONDS_TO_WAIT_10);
        clickWithJs(By.xpath(getButtonInNotesHeader(buttonName)));
    }

    /**
     * selects wanted table format defined by rowNumber * columnNumber
     * @param rowNumber -  number of rows that the table should have
     * @param columnNumber - number of columns that the table should have
     */
    public void selectTable(int rowNumber, int columnNumber) {
        waitByElementsDisplayed(By.xpath(getTableCellLocator(rowNumber, columnNumber)), Constants.SECONDS_TO_WAIT_10);
        clickWithJs(By.xpath(getTableCellLocator(rowNumber, columnNumber)));
        switchToFrame(noteContentFrame);
    }

    /**
     * verifies number of rows in notes displayed table
     * @param expectedNumberOfRows - expected number of rows
     */
    public void verifyRowsInTable(int expectedNumberOfRows) {
        assertThat(getListSize(By.xpath(rowsInTable)), is(expectedNumberOfRows));
    }

    /**
     * verifies number of columns in notes displayed table
     * @param rowNumber            - row number on which the verification of columns is made
     * @param expectedColumnNumber - expected number of rows
     */
    public void verifyColumnsInTable(int rowNumber, int expectedColumnNumber) {
        assertThat(getListSize(By.xpath(getColumnsLocator(rowNumber))), is(expectedColumnNumber));
    }

    /**
     * column xpath constructor
     */
    private String getColumnsLocator(int rowNumber) {
        return "(//table//tr)[" + rowNumber + "]//td";
    }

    /**
     * header note button xpath constructor
     */
    private String getButtonInNotesHeader(String buttonName) {
        return "//div[contains(@id,'" + buttonName + "')]";
    }

    /**
     * note locagtor by title
     */
    private String getNoteByTitleLocator(String noteTitle) {
        return "//div[contains(@class,'noteTitle')][contains(text(),'" + noteTitle + "')]";
    }
}
