package steps;

import components.Header;
import cucumber.api.java.en.And;
import pageObjects.NotesPage;

/**
 * Created by andreapolcz on 6/27/17.
 */
public class NoteSteps {

    private NotesPage note = new NotesPage();
    private Header header = new Header();


    @And("^clicks new note button$")
    public void clicksNewNoteButton() {
        note.clickAddNewNote();
    }


    @And("^put in note title \"([^\"]*)\"$")
    public void putInNoteTitle(String noteTitle) {
        note.putNoteTitle(noteTitle);
    }

    @And("^hits button done$")
    public void hitsButtonDone() {
        header.clickDoneButton();
    }

    @And("^opens note \"([^\"]*)\" from notes list$")
    public void opensNoteFromNotesList(String noteTitle) {
        note.openNoteByTitle(noteTitle);
    }

    @And("^deletes selected note$")
    public void deletesSelectedNote() {
        note.deleteSelectedNote();
    }

    @And("^clicks button \"([^\"]*)\" from insert elements in body header$")
    public void clicksButtonFromInsertElementsInBodyHeader(String buttonName) {
        note.clickButton(buttonName);
    }

    @And("^selects a \"([^\"]*)\" by \"([^\"]*)\" table$")
    public void selectsTableRowByColumn(int rowNumber, int columnNumber) {
        note.selectTable(rowNumber, columnNumber);
    }

    @And("^verifies that there are \"([^\"]*)\" rows in generated table$")
    public void verifiesThatThereAreRowsInGeneratedTable(int expectedNumberOfRows) {
        note.verifyRowsInTable(expectedNumberOfRows);
    }

    @And("^verifies that there are \"([^\"]*)\" columns in a table of \"([^\"]*)\" rows$")
    public void verifiesThatThereAreColumnsInGeneratedTableInATableThatHasRows(int expectedColumnNumber, int actualRowsNumber) {
       for(int rowNumber = 1;rowNumber<=actualRowsNumber;rowNumber++) {
           note.verifyColumnsInTable(rowNumber,expectedColumnNumber);
       }
    }
}
