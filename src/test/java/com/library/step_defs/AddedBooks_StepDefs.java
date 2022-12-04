package com.library.step_defs;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddedBooks_StepDefs {
    LoginPage login1 = new LoginPage();
    BasePage base1 = new BasePage();
BookPage bookPage = new BookPage();

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        login1.login(ConfigurationReader.getProperty("luis_username"), ConfigurationReader.getProperty("luis_password") );
    }
    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String string) {
base1.books.click();
    }
    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
bookPage.addBook.click();
    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName1) {
        bookPage.bookName.sendKeys(bookName1);
    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn1) {
        bookPage.isbn.sendKeys(isbn1);
    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year1) {
        bookPage.year.sendKeys(year1);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author1) {
        bookPage.author.sendKeys(author1);
    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String category) {
        Select select = new Select(bookPage.selectCategory);
        select.selectByVisibleText(category);
    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
bookPage.saveChanges.click();
    }

    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String expected) {
        BrowserUtil.waitFor(2);
        bookPage.search.sendKeys(expected);
        BrowserUtil.waitFor(1);
        String actualBookName = bookPage.bookTextFirstRow.getText();
        Assert.assertEquals(expected, actualBookName);
    }

   @Then("the librarian verify new book from database by {string} and {string}")
    public void the_librarian_verify_new_book_from_database_by(String name1, String author1) {
       DB_Util.runQuery("select id, name, author from books\n" +
               "where name = '" + name1 + "' and author='" + author1 + "'\n" +
               "order by id desc;");



    }



}
