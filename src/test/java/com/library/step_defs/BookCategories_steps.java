package com.library.step_defs;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class BookCategories_steps {

    LoginPage loginPage = new LoginPage();

    BookPage bookPage=new BookPage();

    List<String> actualCategoryList;
    List<String> expectedCategoryList;

    @Given("I login as a {string}")
    public void i_login_as_a(String user) {

        loginPage.login2(user);
    }

    @When("I navigate to {string} page")
    public void i_navigate_to_page(String module) {

        new DashBoardPage().navigateModule(module);
    }
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        String query = "select name from book_categories";

        DB_Util.runQuery(query);

        expectedCategoryList = DB_Util.getColumnDataAsList(1);
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        Assert.assertEquals(expectedCategoryList, actualCategoryList);
    }

}
