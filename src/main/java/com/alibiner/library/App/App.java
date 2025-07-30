package com.alibiner.library.App;

import com.alibiner.library.Application.DTOs.BookDetailDto;
import com.alibiner.library.Application.Services.BookService;
import com.alibiner.library.Infrastructure.BookRepository;
import com.alibiner.library.Service.CustomScanner;

import java.util.List;

public class App {
    CustomScanner scanner = new CustomScanner("Welcome to Library Management System!");
    public void run(){


        BookController bookController = new BookController(new BookService(new BookRepository()));
        String choiceText = "Please select an option:\n" +
                "1. Add A New Book\n" +
                "2. Display All Books\n" +
                "3. Search For A Book By Title\n" +
                "4. Check out a book \n" +
                "6. Exit\n" +
                "Your Choice: ";

        boolean exit = false;
        do {
            int choice = scanner.getAbsoluteRange(choiceText,1,6);
            System.out.println();
            switch (choice){
                case 1:
                    System.out.println("Please Enter The Book Details: ");
                    System.out.println(bookController.add() ? "Book Added Successfully!" : "Failed To Add Book!");
                    break;
                case 2:
                    List<BookDetailDto> bookDetailDtos = bookController.getAllBook();
                    if (bookDetailDtos.isEmpty()){
                        System.out.println("There are no books in the library yet.");
                        break;
                    }
                    for (BookDetailDto dto : bookDetailDtos){
                        System.out.println(dto);
                    }
                    break;
                case 3:
                    String title = scanner.getSentencesRange("Enter book title to search: ", 3);
                    BookDetailDto result = bookController.getByTitle(title);
                    if (result == null)
                        System.out.println("No Matching Data!");
                    else
                        System.out.println(result);
                    break;
                case 4:
                    int id = scanner.getAbsoluteRange("Enter Book Id: ",1);
                    if (!bookController.checkOut(id))
                        System.out.println("This book is not available");
                    else
                        System.out.println("The Book has been reserved for you");
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                default:
                    System.out.println("Please choose between 1 and 6");
                    break;
            }
            System.out.println();
            System.out.println("--------------------------------------------");
            System.out.println();
        }while (!exit);
    }
}
