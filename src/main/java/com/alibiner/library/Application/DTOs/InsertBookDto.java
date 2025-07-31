package com.alibiner.library.Application.DTOs;

import com.alibiner.library.App.CustomScanner;

public class InsertBookDto extends BaseDto{
    private final CustomScanner scanner = new CustomScanner();

    private String title;
    private String author;
    private String ISBN;

    public InsertBookDto() {
        setTitle();
        setAuthor();
        setISBN();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        this.title = scanner.getSentencesRange("Book Name : ", 3);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        this.author = scanner.getSentencesRange("Author Name: ", 3);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN() {
        this.ISBN = scanner.getWordRange("ISBN : ", 10,10);
    }
}
