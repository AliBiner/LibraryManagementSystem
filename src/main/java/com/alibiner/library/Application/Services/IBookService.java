package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BookDetailDto;

public interface IBookService {
    BookDetailDto getByTitle(String title);
    boolean checkOut(long id);
    boolean returnBook(long id);
}
