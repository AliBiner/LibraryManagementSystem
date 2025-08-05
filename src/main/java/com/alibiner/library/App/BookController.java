package com.alibiner.library.App;

import com.alibiner.library.Application.DTOs.Response.BookResponses.BookDetailDto;
import com.alibiner.library.Application.DTOs.Request.BookRequests.InsertBookDto;
import com.alibiner.library.Application.Services.BookService;

import java.util.List;

/**
 * BookController is responsible for handling book-related operations.
 * It connects with the BookService to manage books in the system.
 */
public class BookController {
    /** Service layer for book operations */
    private final BookService bookService;

    /**
     * Constructor for BookController.
     *
     * @param bookService the service used to handle book logic
     */
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Adds a new book to the system.
     * This method creates a new InsertBookDto object (Automatically, asks user book detail)
     * and sends it to the BookService to save the book.
     *
     * @return true if the book was added successfully, false otherwise
     */
    public boolean add(){
        //Auto asks user book detail for insert book in InsertBookDto
        InsertBookDto dto = new InsertBookDto();
        // send data to the service to add
        return bookService.add(dto);
    }

    /**
     * Gets all books in the system.
     *
     * @return a list of BookDetailDto containing all books
     */
    public List<BookDetailDto> getAllBook(){
        //Route request to book service without parameters
        return (List<BookDetailDto>) bookService.getAll();
    }

    /**
     * Finds books by their title.
     *
     * @param title the title to search for
     * @return a list of books that match the given title
     */
    public List<BookDetailDto> getByTitle(String title) {
        return bookService.getByTitle(title);
    }

    /**
     * Checks out (borrows) a book by its ID.
     *
     * @param id the ID of the book to check out
     * @return true if the book was checked out successfully, false otherwise
     */
    public boolean checkOut(long id){
        return bookService.checkOut(id);
    }

    /**
     * Returns a borrowed book by its ID.
     *
     * @param id the ID of the book to return
     * @return true if the book was returned successfully, false otherwise
     */
    public boolean returnBook(long id){ return bookService.returnBook(id); }
}
