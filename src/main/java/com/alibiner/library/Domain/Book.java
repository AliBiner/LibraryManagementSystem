package com.alibiner.library.Domain;

import com.alibiner.library.Service.CustomScanner;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Book extends BaseEntity {
    private CustomScanner scanner;
    private final AtomicInteger autoIncrementStock = new AtomicInteger(0);
    private String title;
    private String author;
    private String ISBN;
    private int page;
    private int stock;
    private boolean checkOut;

    public Book(String title,String author,String ISBN) {
        scanner = new CustomScanner();
        setTitle(title);
        setAuthor(author);
        setISBN(ISBN);
        checkoutEnabled();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length()<3)
            throw new IllegalArgumentException("Title can not be less 3 character! Title length: "+ title.length());
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.length()<3)
            throw new IllegalArgumentException("Author can not be less 3 character! Author length: " + author.length() );
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if (ISBN.length()!=10)
            throw new IllegalArgumentException("ISBN must be 10 character long! ISBN length: " + ISBN.length());
        this.ISBN = ISBN;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page<0)
            throw new IllegalArgumentException("Page count cannot be less 0! Page: "+ page);
        this.page = page;
    }

    public int getStock() {
        return stock;
    }

    public void setStock() {
        this.stock = autoIncrementStock.incrementAndGet();
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void checkoutEnabled() {
        this.checkOut = true;
    }

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
                ", page= " + page +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Book book = (Book) o;
        return page == book.page && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(ISBN, book.ISBN);
    }
}
