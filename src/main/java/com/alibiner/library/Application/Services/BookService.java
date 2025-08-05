package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BaseDto;
import com.alibiner.library.Application.DTOs.Response.BookResponses.BookDetailDto;
import com.alibiner.library.Application.DTOs.Request.BookRequests.InsertBookDto;
import com.alibiner.library.Application.Mappers.BookMappers.BookDetailDtoMapper;
import com.alibiner.library.Application.Mappers.BookMappers.InsertBookDtoTo;
import com.alibiner.library.Application.Services.Interfaces.GenericService;
import com.alibiner.library.Domain.Book;
import com.alibiner.library.Infrastructure.Repositories.BookRepository;
import com.alibiner.library.Infrastructure.Interfaces.GenericRepository;

import java.util.List;

/**
 * BookService is a class that handles the business logic for book-related operations.
 * It implements the GenericService interface and works with a BookRepository to manage books.
 */
public class BookService implements GenericService {
    /** Repository layer used to access and manage book data */
    private final BookRepository bookRepository;

    /**
     * Constructor for BookService.
     * Converts a generic repository into a BookRepository.
     *
     * @param genericRepository the generic repository passed from controller
     */
    public BookService(GenericRepository genericRepository) {
        bookRepository = (BookRepository) genericRepository;
    }


    /**
     * Adds a new book to the system.
     * If the book does not already exist, it saves the book.
     *
     * @param dto the book data to be inserted (must be InsertBookDto)
     * @return true if added successfully, false if book already exists
     */
    @Override
    public boolean add(BaseDto dto) {
        InsertBookDtoTo insertBookDtoTo = new InsertBookDtoTo();
        Book book = insertBookDtoTo.mapToEntity((InsertBookDto) dto);
        if (!isExist(book)){
            return bookRepository.add(book);
        }
        else{
            return false;
        }
    }

    /**
     * Returns all books in the system.
     *
     * @return a list of BookDetailDto containing all book data
     */
    @Override
    public List<? extends BaseDto> getAll() {
        return new BookDetailDtoMapper().mapToDto(bookRepository.getAll());
    }


    /**
     * Checks whether a book already exists in the system.
     *
     * @param book the book to check
     * @return true if the book exists, false otherwise
     */
    public boolean isExist(Book book){
        return bookRepository.isExist(book);
    }

    /**
     * Searches for books by their title.
     *
     * @param title the title to search for
     * @return a list of matching BookDetailDto, or null if no books found
     */
    public List<BookDetailDto> getByTitle(String title) {
        List<Book> books = bookRepository.getByTitle(title);
        if (books.size()==0)
            return null;
        return new BookDetailDtoMapper().mapToDto(books);
    }


    /**
     * Checks out (reserves) a book by ID.
     * A book can be checked out only if it's not already reserved.
     *
     * @param id the ID of the book
     * @return true if the book is successfully checked out, false otherwise
     */
    public boolean checkOut(long id) {
        Book book = bookRepository.getById(id);
        if (book == null || !book.isCheckOut())
            return false;
        book.checkoutDisabled();
        return bookRepository.update(book);
    }

    /**
     * Returns a previously checked out book.
     * The book must already be reserved.
     *
     * @param id the ID of the book to return
     * @return true if the book was successfully returned, false otherwise
     */
    public boolean returnBook(long id) {
        Book book = bookRepository.getById(id);
        if (book == null || book.isCheckOut())
            return false;
        book.checkoutEnabled();
        return bookRepository.update(book);
    }
}
