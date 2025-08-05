package com.alibiner.library.Application.DTOs.Request.BookRequests;

import com.alibiner.library.App.CustomScanner;
import com.alibiner.library.Application.DTOs.BaseDto;

/**
 * InsertBookDto is a Data Transfer Object (DTO) used to take user input when adding a new book.
 * <p>
 * It asks for the book's title, author, and ISBN using a custom scanner with input validation.
 * When a new InsertBookDto is created, it asks the user for these details.
 */
public class InsertBookDto implements BaseDto {

    /** Scanner used for safe user input */
    private final CustomScanner scanner = new CustomScanner();

    /** Title of the book */
    private String title;

    /** Author of the book */
    private String author;

    /** ISBN number of the book */
    private String ISBN;

    /**
     * Constructor.
     * When called, it asks the user to enter title, author, and ISBN.
     */
    public InsertBookDto() {
        setTitle();
        setAuthor();
        setISBN();
    }

    /**
     * Gets the title of the book.
     *
     * @return the book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Asks the user to enter the book title and sets it.
     * The title must be at least 3 characters long.
     */
    public void setTitle() {
        this.title = scanner.getSentencesRange("Book Name : ", 3);
    }

    /**
     * Gets the author of the book.
     *
     * @return the book author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Asks the user to enter the author name and sets it.
     * The author name must be at least 3 characters long.
     */
    public void setAuthor() {
        this.author = scanner.getSentencesRange("Author Name: ", 3);
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return the ISBN number
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Asks the user to enter the ISBN and sets it.
     * The ISBN must be exactly 10 characters long.
     */
    public void setISBN() {
        this.ISBN = scanner.getWordRange("ISBN : ", 10,10);
    }
}
