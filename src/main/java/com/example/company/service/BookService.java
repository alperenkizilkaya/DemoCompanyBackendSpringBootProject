package com.example.company.service;

import com.example.company.dto.BookRequest;
import com.example.company.dto.BookResponse;
import com.example.company.exception.BookNotFoundException;

import java.util.List;

public interface BookService {
    BookResponse addBook(BookRequest req);

    BookResponse getBookById(Long id) throws BookNotFoundException;

    BookResponse removeBook(Long id) throws BookNotFoundException;

    List<BookResponse> getAllEmployees();

    BookResponse updateBook(Long id, BookRequest req) throws BookNotFoundException;
}
