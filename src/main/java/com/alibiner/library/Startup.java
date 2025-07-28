package com.alibiner.library;

import com.alibiner.library.App.App;
import com.alibiner.library.App.BookController;
import com.alibiner.library.Application.DTOs.GetAllBookDto;
import com.alibiner.library.Application.DTOs.InsertBookDto;
import com.alibiner.library.Application.Services.BookService;
import com.alibiner.library.Infrastructure.BookRepository;
import com.alibiner.library.Service.CustomScanner;

import java.util.Scanner;


public class Startup {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
