package com.alibiner.library.Application.Mappers.BookMappers;

import com.alibiner.library.Application.DTOs.BookDetailDto;
import com.alibiner.library.Application.Mappers.Interfaces.IBaseMapper;
import com.alibiner.library.Domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDetailDtoMapper implements IBaseMapper<Book, BookDetailDto> {

    @Override
    public Book mapToEntity(BookDetailDto source) {
        return null;
    }

    @Override
    public List<Book> mapToEntity(List<BookDetailDto> source) {
        return List.of();
    }

    @Override
    public BookDetailDto mapToDto(Book source) {
        BookDetailDto dto = new BookDetailDto();
        dto.setId(source.getId());
        dto.setISBN(source.getISBN());
        dto.setAuthor(source.getAuthor());
        dto.setCheckOutStatus(source.isCheckOut());
        dto.setTitle(source.getTitle());
        return dto;
    }

    @Override
    public List<BookDetailDto> mapToDto(List<Book> source) {
        List<BookDetailDto> dtoList = new ArrayList<>();
        for (Book book : source){
            BookDetailDto dto = new BookDetailDto();
            dto.setId(book.getId());
            dto.setISBN(book.getISBN());
            dto.setAuthor(book.getAuthor());
            dto.setCheckOutStatus(book.isCheckOut());
            dto.setTitle(book.getTitle());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
