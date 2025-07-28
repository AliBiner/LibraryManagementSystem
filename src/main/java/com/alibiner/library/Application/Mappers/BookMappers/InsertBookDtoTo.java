package com.alibiner.library.Application.Mappers.BookMappers;


import com.alibiner.library.Application.DTOs.InsertBookDto;
import com.alibiner.library.Application.Mappers.Interfaces.IBaseMapper;
import com.alibiner.library.Domain.Book;

import java.util.List;

public class InsertBookDtoTo implements IBaseMapper<Book, InsertBookDto> {

    @Override
    public Book mapToEntity(InsertBookDto source) {
        return new Book(source.getTitle(),source.getAuthor(),source.getISBN());
    }

    @Override
    public List<Book> mapToEntity(List<InsertBookDto> source) {
        return List.of();
    }

    @Override
    public InsertBookDto mapToDto(Book source) {
        return null;
    }

    @Override
    public List<InsertBookDto> mapToDto(List<Book> source) {
        return List.of();
    }
}
