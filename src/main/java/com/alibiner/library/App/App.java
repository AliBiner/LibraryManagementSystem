package com.alibiner.library.App;

import com.alibiner.library.Application.DTOs.Response.BookResponses.BookDetailDto;
import com.alibiner.library.Application.Services.BookService;
import com.alibiner.library.Infrastructure.Repositories.BookRepository;

import java.util.List;

/**
 * The App class represents the main class of the Library Management System.
 * It contains the main logic and menu options for interacting with the system.
 * <p>
 * Features:
 * <ul>
 *     <li>Add a new book</li>
 *     <li>Display all books</li>
 *     <li>Search for a book by title</li>
 *     <li>Check out a book</li>
 *     <li>Return a book</li>
 *     <li>Exit the application</li>
 * </ul>
 */
public class App {

    /** Custom scanner used for safe user input and welcome message */
    private final CustomScanner scanner = new CustomScanner("Welcome to Library Management System!");


    /** Book controller (start the options) - used a singleton */
    private final BookController bookController;

    public App() {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        this.bookController = new BookController(bookService);
    }

    /**
     * Runs the library application.
     * Displays a menu and performs the selected operation.
     */
    public void run(){

        // Text to show menu options
        String choiceText = "Please select an option:\n" +
                "1. Add A New Book\n" +
                "2. Display All Books\n" +
                "3. Search For A Book By Title\n" +
                "4. Check out a book \n" +
                "5. Return a book \n" +
                "6. Exit\n" +
                "Your Choice: ";

        // Application loop control variable
        boolean exit = false;

        // Start menu loop
        do {
            // Ask user for choice between 1 and 6
            int choiceOption = scanner.getAbsoluteRange(choiceText,1,6);
            System.out.println();
            switch (choiceOption){
                // Option 1: Add a new book
                case 1:
                    System.out.println("Please Enter The Book Details: ");

                    // Create BookController with dependency injection (scoped)
                    boolean result = bookController.add();

                    // Print success or failure message
                    System.out.println(result ? "Book Added Successfully!" : "Failed To Add Book!");
                    break;

                // Option 2: Display all books
                case 2:
                    List<BookDetailDto> bookDetailDtos = bookController.getAllBook();

                    // Check if the library is empty
                    if (bookDetailDtos.isEmpty()){
                        System.out.println("There are no books in the library yet.");
                        break;
                    }

                    // Print each book
                    for (BookDetailDto dto : bookDetailDtos){
                        System.out.println(dto);
                    }
                    break;

                // Option 3: Search for a book by title
                case 3:
                    String title = scanner.getSentencesRange("Enter book title to search: ", 3);

                    List<BookDetailDto> dtos = bookController.getByTitle(title);

                    // Check for null or empty results
                    if (dtos == null || dtos.isEmpty())
                        System.out.println("No Matching Data!");
                    else
                        //Print all books match by title
                        for (BookDetailDto dto : dtos)
                            System.out.println(dto);
                    break;

                // Option 4: Check out a book
                case 4:
                    long checkOutId = scanner.getAbsoluteRange("Enter book id to check out: ",1);

                    boolean checkOut = bookController.checkOut(checkOutId);

                    // Print result message
                    if (!checkOut)
                        System.out.println("This book already reserved for other");
                    else
                        System.out.println("The book has been reserved for you");
                    break;

                // Option 5: Return a book
                case 5:
                    long returnBookId = scanner.getAbsoluteRange("Enter book id to return: ", 1);

                    boolean returnBook = bookController.returnBook(returnBookId);

                    if (!returnBook)
                        System.out.println("This book has not yet been reserved");
                    else
                        System.out.println("The book received");

                    break;

                // Option 6: Exit the application
                case 6:
                    exit = true;
                    System.out.println("Thank you for using the Library Management System!");
                    break;

                // If user somehow enters unexpected value (shouldn’t happen)
                default:
                    System.out.println("Please choose between 1 and 6");
                    break;
            }
            System.out.println();
            System.out.println("--------------------------------------------");
            System.out.println();
        }while (!exit); // Continue until user chooses to exit

    }
}
