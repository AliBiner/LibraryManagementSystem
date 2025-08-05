package com.alibiner.library.Application.Mappers.BookMappers;

import com.alibiner.library.Application.DTOs.Response.BookResponses.BookDetailDto;
import com.alibiner.library.Application.Mappers.Interfaces.DtoToEntityMapper;
import com.alibiner.library.Application.Mappers.Interfaces.EntityToDtoMapper;
import com.alibiner.library.Domain.Book;

import java.util.ArrayList;
import java.util.List;


/**
 * BookDetailDtoMapper is a class that converts Book objects to BookDetailDto objects.
 * <p>
 * It is used to show book data to the user in a clean and simple format.
 * This class only supports mapping from Entity (Book) to DTO (BookDetailDto).
 * Mapping from DTO to Entity is not used here, so those methods return empty.
 *
 * @see Book
 * @see BookDetailDto
 */
public class BookDetailDtoMapper implements EntityToDtoMapper<Book, BookDetailDto> {

    /**
     * Converts one Book entity to a BookDetailDto.
     *
     * @param source the Book object
     * @return the mapped BookDetailDto object
     */
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

    /**
     * Converts a list of Book entities to a list of BookDetailDto objects.
     *
     * @param source the list of Book objects
     * @return a list of BookDetailDto objects
     */
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
