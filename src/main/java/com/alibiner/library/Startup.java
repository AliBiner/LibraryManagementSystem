package com.alibiner.library;

import com.alibiner.library.App.BookController;
import com.alibiner.library.Application.Mappers.BookMapper;
import com.alibiner.library.Application.Mappers.IBaseMapper;
import com.alibiner.library.Application.Services.BookService;
import com.alibiner.library.Domain.Book;
import com.alibiner.library.Infrastructure.BookRepository;
import com.alibiner.library.Service.ServiceBuilder;

public class Startup {
    public static void main(String[] args) {
        BookController bookController = new BookController(new BookService(new BookMapper(),new BookRepository()));
        bookController.add();
    }
}
