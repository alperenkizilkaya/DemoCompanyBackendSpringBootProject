package com.example.company.controller;

import com.example.company.dto.*;
import com.example.company.exception.BookNotFoundException;
import com.example.company.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    BookResponse addBook(@RequestBody BookRequest req){
        return bookService.addBook(req);
    }

    @GetMapping("/{id}")
    BookResponse getBookById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    BookResponse deleteBookById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.removeBook(id);
    }

    @GetMapping("/all")
    List<BookResponse> getAllEmployees(){
        return bookService.getAllEmployees();
    }

    @PutMapping("/{id}")
    BookResponse updateEmployee(@PathVariable Long id,@RequestBody BookRequest req) throws BookNotFoundException {
        return bookService.updateBook(id, req);
    }
}
