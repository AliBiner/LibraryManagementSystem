package com.alibiner.library.Infrastructure;

import com.alibiner.library.Domain.Book;

import java.util.List;

public class BookRepository extends GenericRepository<Book> implements IBookRepository<Book> {
    @Override
    public Book getByTitle(String title) {
        return super
                .list
                .stream()
                .filter(element -> element.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}
