package com.alibiner.library.App;

import com.alibiner.library.Application.DTOs.GetAllBookDto;
import com.alibiner.library.Application.DTOs.InsertBookDto;
import com.alibiner.library.Application.Mappers.BookMappers.InsertBookDtoTo;
import com.alibiner.library.Application.Mappers.BookMappers.ToGetAllBookDto;
import com.alibiner.library.Application.Services.BookService;

import java.util.List;

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public boolean add(){
        InsertBookDto dto = new InsertBookDto();
        return bookService.add(dto);
    }

    public List<GetAllBookDto> getAllBook(){
        bookService.setMapper(new ToGetAllBookDto());
        return bookService.getAll();
    }
}
