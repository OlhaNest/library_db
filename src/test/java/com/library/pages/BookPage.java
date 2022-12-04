package com.library.pages;


import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookPage {

    public BookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement bookName;


    @FindBy(xpath = "//input[@name='author']")
    public WebElement author;


    @FindBy(xpath = "//input[@name='year']")
    public WebElement year;

    @FindBy(xpath = "//input[@name='isbn']")
    public WebElement isbn;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(xpath = "//i[@class='fa fa-plus']" )
    public WebElement addBook;

    @FindBy(xpath = "//select[@id='book_group_id']")
    public WebElement selectCategory;

@FindBy(xpath = "//button[.='Save changes']")
public WebElement saveChanges;

@FindBy(xpath = "//table[@id='tbl_books']//tr[1]//td[3]")
public WebElement bookTextFirstRow;

    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }




}
