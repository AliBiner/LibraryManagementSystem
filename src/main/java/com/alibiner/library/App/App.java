package com.alibiner.library.App;

import com.alibiner.library.Application.DTOs.GetAllBookDto;
import com.alibiner.library.Application.Services.BookService;
import com.alibiner.library.Infrastructure.BookRepository;
import com.alibiner.library.Service.CustomScanner;

import java.util.List;

public class App {
    public void run(){
        CustomScanner scanner = new CustomScanner("Welcome to Library Management System!");

        BookController bookController = new BookController(new BookService(new BookRepository()));
        String choiceText = "Please select an option:\n" +
                "1. Add A New Book\n" +
                "2. Display All Books\n" +
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
                    List<GetAllBookDto> getAllBookDtos = bookController.getAllBook();
                    if (getAllBookDtos.isEmpty()){
                        System.out.println("There are no books in the library yet.");
                        break;
                    }
                    for (GetAllBookDto dto : getAllBookDtos){
                        System.out.println(dto);
                    }
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
