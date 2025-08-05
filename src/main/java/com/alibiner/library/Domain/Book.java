package com.alibiner.library.Domain;

import java.util.Objects;

/**
 * Book class represents a book in the library system.
 * <p>
 * It holds basic information like title, author, ISBN, and checkout status.
 * This class extends {@link BaseEntity}, so it also has id, status, and timestamps.
 *
 * @see BaseEntity
 */
public class Book extends BaseEntity {
    /** Name of the book */
    private String title;

    /** Name of the author */
    private String author;

    /** ISBN number (must be 10 characters) */
    private String ISBN;

    /** Shows if the book is available (true) or already reserved (false) */
    private boolean checkOut;

    /**
     * Creates a new Book with title, author, and ISBN.
     * Also sets the book as available (checkOut = true).
     *
     * @param title  the book's title
     * @param author the book's author
     * @param ISBN   the book's ISBN (must be 10 characters)
     */
    public Book(String title,String author,String ISBN) {
        setTitle(title);
        setAuthor(author);
        setISBN(ISBN);
        checkoutEnabled();
    }

    /**
     * Gets the book's title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the book's title.
     * The title must be at least 3 characters long.
     *
     * @param title the new title
     * @throws IllegalArgumentException if title is too short
     */
    public void setTitle(String title) {
        if (title.length()<3)
            throw new IllegalArgumentException("Title can not be less 3 character! Title length: "+ title.length());
        this.title = title;
    }


    /**
     * Gets the book's author.
     *
     * @return the author name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the book's author.
     * The author name must be at least 3 characters long.
     *
     * @param author the new author
     * @throws IllegalArgumentException if author name is too short
     */
    public void setAuthor(String author) {
        if (author.length()<3)
            throw new IllegalArgumentException("Author can not be less 3 character! Author length: " + author.length() );
        this.author = author;
    }

    /**
     * Gets the book's ISBN.
     *
     * @return the ISBN string
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the book's ISBN.
     * ISBN must be exactly 10 characters long.
     *
     * @param ISBN the new ISBN
     * @throws IllegalArgumentException if ISBN length is not 10
     */
    public void setISBN(String ISBN) {
        if (ISBN.length()!=10)
            throw new IllegalArgumentException("ISBN must be 10 character long! ISBN length: " + ISBN.length());
        this.ISBN = ISBN;
    }


    /**
     * Checks if the book is available to be borrowed.
     *
     * @return true if available, false if already reserved
     */
    public boolean isCheckOut() {
        return checkOut;
    }

    /**
     * Marks the book as available (can be borrowed).
     */
    public void checkoutEnabled() {
        this.checkOut = true;
    }

    /**
     * Marks the book as reserved (already borrowed).
     */
    public void checkoutDisabled(){
        this.checkOut = false;
    }


    @Override
    public String toString() {
        return "Book{" +
                super.toString() +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Book book = (Book) o;
        return  Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(ISBN, book.ISBN);
    }
}
