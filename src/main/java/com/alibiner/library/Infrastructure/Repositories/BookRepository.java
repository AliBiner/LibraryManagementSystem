package com.alibiner.library.Infrastructure.Repositories;

import com.alibiner.library.Domain.Book;
import com.alibiner.library.Infrastructure.FakeDataBase.FakeBookDatabase;

import java.util.List;

/**
 * BookRepository is a class to manage Book objects in the data storage.
 * <p>
 * It extends the GenericRepository to use common data methods like add, getAll, update, etc.
 * <p>
 * This class adds a special method to find books by their title.
 *
 * @see GenericRepository
 */
public class BookRepository extends GenericRepository<Book> {

    public BookRepository() {
        super(FakeBookDatabase.getBookTable());
    }

    /**
     * Finds and returns a list of books where the title contains the given text.
     * The search is not case-sensitive.
     *
     * @param title the text to search inside book titles
     * @return a list of books with matching titles; empty list if none found
     */
    public List<Book> getByTitle(String title) {
        return  this.list
                .stream()
                .filter(element -> element.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }
}
