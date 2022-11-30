package com.library.step_defs;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class BookBorrowStepDefs {

    String actualMostPopularGenre;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        //done through Hooks class
    }
    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc");
        String expectedMostPupularGenre = DB_Util.getAnyRowAnyColumnValue(1,1);
        System.out.println(actualMostPopularGenre);

    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedMostPopularGenre) {
        System.out.println(actualMostPopularGenre);
        Assert.assertEquals(expectedMostPopularGenre, actualMostPopularGenre);
    }




}
