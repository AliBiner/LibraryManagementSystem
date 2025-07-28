package com.alibiner.library.Application.Mappers;

import com.alibiner.library.Application.DTOs.InsertBookDto;
import com.alibiner.library.Domain.Book;

public class BookMapper implements IBaseMapper<Book,InsertBookDto> {

    @Override
    public Book get(InsertBookDto dto) {
        return new Book(dto.getTitle(), dto.getAuthor(), dto.getISBN());
    }
}
