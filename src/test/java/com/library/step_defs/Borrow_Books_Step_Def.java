package com.library.step_defs;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Borrow_Books_Step_Def {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
    BookPage bookPage = new BookPage();
    @Given("I login as a student with {string} and {string} credentials")
    public void i_login_as_a_student_with_and_credentials(String email, String password) {
        loginPage.login(email,password);
        BrowserUtil.waitFor(2);

    }
    @Given("I navigate to Books page")
    public void i_navigate_to_books_page() {
        dashBoardPage.books.click();
    }
    @Given("I search book name called {string}")
    public void i_search_book_name_called(String string) {
        bookPage.search.sendKeys(string);
    }
    @When("I click Borrow Book")
    public void i_click_borrow_book() {
        bookPage.orderBtn.click();

    }
    @Then("verify that book is shown in \"Borrowing Books” page")
    public void verify_that_book_is_shown_in_borrowing_books_page() {

    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

    }
}
