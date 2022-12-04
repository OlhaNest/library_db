package com.library.step_defs;

import com.library.pages.BasePage;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddedBooks_StepDefs {
    LoginPage login1 = new LoginPage();


    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        login1.login(ConfigurationReader.getProperty("luis_username"), ConfigurationReader.getProperty("luis_password") );
    }

    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String string) {

    }
    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the librarian verify new book from database by {string}")
    public void the_librarian_verify_new_book_from_database_by(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
