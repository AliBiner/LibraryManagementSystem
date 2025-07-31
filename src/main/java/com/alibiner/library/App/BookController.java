package com.alibiner.library.App;

import com.alibiner.library.Application.DTOs.BookDetailDto;
import com.alibiner.library.Application.DTOs.InsertBookDto;
import com.alibiner.library.Application.Mappers.BookMappers.BookDetailDtoMapper;
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

    public List<BookDetailDto> getAllBook(){
        bookService.setMapper(new BookDetailDtoMapper());
        return bookService.getAll();
    }

    public BookDetailDto getByTitle(String title) {
        return bookService.getByTitle(title);
    }

    public boolean checkOut(long id){
        return bookService.checkOut(id);
    }

    public boolean returnBook(long id){ return bookService.returnBook(id); }
}
