# 📚 Library Management System (Console App)

This is a simple **Java Console Application** for managing a small library system.

The project is created using **Core Java**, and it follows **Clean Code** and **SOLID Principles** with a layered architecture.

---

## 🧩 Features

- Add a new book
- List all books
- Search for a book by title
- Check out a book (mark as reserved)
- Return a book (mark as available)
- Exit the system

---

## 🗂️ Project Structure

- `App`: Main class to run the program.
- `CustomScanner`: Handles user input with validation.
- `Book`: Entity class for a book.
- `BookRepository`: Manages book list (fake in-memory database).
- `BookService`: Contains business logic.
- `BookController`: Connects service with UI (console).
- `Dto classes`: Used to transfer data between layers.
- `Mapper classes`: Convert between entity and DTO.

---

## 🧪 Technologies

- Java 21
- No external libraries
- No database used (it uses a list like a fake database)

---

## 💡 Design Principles

- **Single Responsibility Principle** – Each class has only one job.
- **Open/Closed Principle** – Code is open for extension, but closed for change.
- **Generic Structure** – Used in Repository, Service, and Mapper for flexibility.
- **Manual Dependency Injection** – All class dependencies are passed by constructor.

---

## ▶️ How to Run

1. Clone the repository or download the ZIP file.
2. Open the project in your IDE (like IntelliJ or Eclipse).
3. Run the `App` class.
4. Follow the console instructions.

---

## 🚧 Notes

- This project is for **educational purposes**.
- It does not use a real database or Spring framework.
- You can improve it by adding file/database support or GUI/REST API.

---

## 📫 Contact

Created by **Ali Biner** – If you have questions, feel free to reach out!

---

## 📌 Example

    Welcome to Library Management System!
    
    
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 1
    
    Please Enter The Book Details:
    Book Name : a
    Invalid input! Must be at least 3 characters.
    Book Name : Clean Code
    Author Name: a
    Invalid input! Must be at least 3 characters.
    Author Name: Mark Zuckerberg
    ISBN : 1
    Invalid input! Must be 10 characters.
    ISBN : 1234567890
    Book Added Successfully!
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 1
    
    Please Enter The Book Details:
    Book Name : Solid Code Principles
    Author Name: Elon Musk
    ISBN : 1234567891
    Book Added Successfully!
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 2
    
    █ ██████████████████████████ █
    █                            █
    █ Id: 1                      █
    █ Title : Clean Code         █
    █ Author: Mark Zuckerberg    █
    █ ISBN : 1234567890          █
    █ Status: Available          █
    █                            █
    █ ██████████████████████████ █
    █ ████████████████████████████ █
    █                              █
    █ Id: 2                        █
    █ Title : Solid Code Principles █
    █ Author: Elon Musk            █
    █ ISBN : 1234567891            █
    █ Status: Available            █
    █                              █
    █ ████████████████████████████ █
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 3
    
    Enter book title to search: clean
    █ ██████████████████████████ █
    █                            █
    █ Id: 1                      █
    █ Title : Clean Code         █
    █ Author: Mark Zuckerberg    █
    █ ISBN : 1234567890          █
    █ Status: Available          █
    █                            █
    █ ██████████████████████████ █
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 3
    
    Enter book title to search: code
    █ ██████████████████████████ █
    █                            █
    █ Id: 1                      █
    █ Title : Clean Code         █
    █ Author: Mark Zuckerberg    █
    █ ISBN : 1234567890          █
    █ Status: Available          █
    █                            █
    █ ██████████████████████████ █
    █ ████████████████████████████ █
    █                              █
    █ Id: 2                        █
    █ Title : Solid Code Principles █
    █ Author: Elon Musk            █
    █ ISBN : 1234567891            █
    █ Status: Available            █
    █                              █
    █ ████████████████████████████ █
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 4
    
    Enter book id to check out: 1
    The book has been reserved for you
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 4
    
    Enter book id to check out: 1
    This book already reserved for other
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 5
    
    Enter book id to return: 1
    The book received
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 5
    
    Enter book id to return: 1
    This book has not yet been reserved
    
    --------------------------------------------
    
    Please select an option:
    1. Add A New Book
    2. Display All Books
    3. Search For A Book By Title
    4. Check out a book
    5. Return a book
    6. Exit
    Your Choice: 6
    
    Thank you for using the Library Management System!
    
    --------------------------------------------


    