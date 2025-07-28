package com.alibiner.library.Domain;

import com.alibiner.library.Service.CustomScanner;

public class Book extends BaseEntity {
    private CustomScanner scanner;

    private String title;
    private String author;
    private String ISBN;
    private int page;

    public Book(String title,String author,String ISBN) {
        scanner = new CustomScanner();
        setTitle(title);
        setAuthor(author);
        setISBN(ISBN);
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
}
