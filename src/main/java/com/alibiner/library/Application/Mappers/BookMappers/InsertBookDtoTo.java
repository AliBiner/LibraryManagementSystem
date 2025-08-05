package com.alibiner.library.Application.Mappers.BookMappers;


import com.alibiner.library.Application.DTOs.Request.BookRequests.InsertBookDto;
import com.alibiner.library.Application.Mappers.Interfaces.DtoToEntityMapper;
import com.alibiner.library.Domain.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * InsertBookDtoTo is a mapper class that converts InsertBookDto to Book entity.
 * <p>
 * It is used when a new book is added. The data comes from the user in InsertBookDto format,
 * and this class turns it into a Book object for saving in the system.
 * <p>
 * Other methods (DTO to entity list or entity to DTO) are not used, so they return empty or null.
 *
 * @see InsertBookDto
 * @see Book
 */
public class InsertBookDtoTo implements DtoToEntityMapper<Book, InsertBookDto> {

    /**
     * Converts one InsertBookDto to a Book object.
     * This method is used when the user adds a new book.
     *
     * @param source the InsertBookDto with user input
     * @return a new Book object created from the DTO
     */
    @Override
    public Book mapToEntity(InsertBookDto source) {
        return new Book(source.getTitle(),source.getAuthor(),source.getISBN());
    }

    /**
     * Not used in this system. Returns an empty list.
     * Normally, it should convert a list of DTOs to Books.
     *
     * @param source list of InsertBookDto (not used)
     * @return empty list
     */
    @Override
    public List<Book> mapToEntity(List<InsertBookDto> source) {
        List<Book> books = new ArrayList<>();
        for(InsertBookDto dto : source){
            books.add(
                    new Book(dto.getTitle(), dto.getAuthor(), dto.getISBN())
            );
        }
        return books;
    }

}
