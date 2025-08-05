package com.alibiner.library.Infrastructure.FakeDataBase;

import com.alibiner.library.Domain.Book;

import java.awt.*;
import java.util.ArrayList;

public class FakeBookDatabase {
    private static final ArrayList<Book> bookTable = new ArrayList<>();

    public static ArrayList<Book> getBookTable(){
        return bookTable;
    }
}
