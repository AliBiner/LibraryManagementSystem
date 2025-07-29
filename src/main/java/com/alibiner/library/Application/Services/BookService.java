package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BaseDto;
import com.alibiner.library.Application.DTOs.BookDetailDto;
import com.alibiner.library.Application.DTOs.InsertBookDto;
import com.alibiner.library.Application.Mappers.BookMappers.BookDetailDtoMapper;
import com.alibiner.library.Application.Mappers.BookMappers.InsertBookDtoTo;
import com.alibiner.library.Domain.Book;
import com.alibiner.library.Infrastructure.BookRepository;
import com.alibiner.library.Infrastructure.IGenericRepository;


public class BookService extends GenericService implements IBookService {
    private final BookRepository bookRepository;
    public BookService(IGenericRepository genericRepository) {
        super( genericRepository);
        bookRepository = (BookRepository) genericRepository;
    }

    @Override
    public boolean add(BaseDto dto) {
        InsertBookDtoTo insertBookDtoTo = new InsertBookDtoTo();
        Book book = insertBookDtoTo.mapToEntity((InsertBookDto) dto);
        if (!isExist(book)){
            super.setMapper(insertBookDtoTo);
            return bookRepository.add(book);
        }
        else{
            return false; // change will after update option
        }
    }


    public boolean isExist(Book book){
        return bookRepository.isExist(book);
    }

    @Override
    public BookDetailDto getByTitle(String title) {
        Book book = bookRepository.getByTitle(title);
        if (book == null)
            return null;
        return new BookDetailDtoMapper().mapToDto(book);
    }
}
