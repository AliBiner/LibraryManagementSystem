package com.alibiner.library.Application.Mappers.BookMappers;

import com.alibiner.library.Application.DTOs.GetAllBookDto;
import com.alibiner.library.Application.Mappers.Interfaces.IBaseMapper;
import com.alibiner.library.Domain.Book;

import java.util.ArrayList;
import java.util.List;

public class ToGetAllBookDto implements IBaseMapper<Book,GetAllBookDto> {

    @Override
    public Book mapToEntity(GetAllBookDto source) {
        return null;
    }

    @Override
    public List<Book> mapToEntity(List<GetAllBookDto> source) {
        return List.of();
    }

    @Override
    public GetAllBookDto mapToDto(Book source) {
        return null;
    }

    @Override
    public List<GetAllBookDto> mapToDto(List<Book> source) {
        List<GetAllBookDto> dtoList = new ArrayList<>();
        for (Book book : source){
            GetAllBookDto dto = new GetAllBookDto();
            dto.setId(book.getId());
            dto.setISBN(book.getISBN());
            dto.setPage(book.getPage());
            dto.setAuthor(book.getAuthor());
            dto.setStatus(book.isStatus());
            dto.setTitle(book.getTitle());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
