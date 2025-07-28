package com.alibiner.library.App;

import com.alibiner.library.Application.DTOs.InsertBookDto;
import com.alibiner.library.Application.Mappers.BookMapper;
import com.alibiner.library.Application.Services.BookService;
import com.alibiner.library.Application.Services.GenericService;

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public boolean add(){
        InsertBookDto dto = new InsertBookDto();
        return bookService.add(dto);
    }
}
