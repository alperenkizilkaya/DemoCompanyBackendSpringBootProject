package com.example.company.service;

import com.example.company.dto.*;
import com.example.company.exception.BookNotFoundException;
import com.example.company.model.Book;
import com.example.company.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookResponse addBook(BookRequest req) {
        var book = modelMapper.map(req, Book.class);
        return modelMapper.map(bookRepository.save(book), BookResponse.class);
    }

    @Override
    public BookResponse getBookById(Long id) throws BookNotFoundException {
        var book = bookRepository.findById(id);
        if(book.isPresent()) {
            BookResponse response = modelMapper.map(book.get(), BookResponse.class);
            return response;
        }
        throw new BookNotFoundException("Book not found with id : " + id);
    }

    @Override
    public BookResponse removeBook(Long id) throws BookNotFoundException {
        var book = bookRepository.findById(id);
        if(book.isPresent()) {
            bookRepository.delete(book.get());
            return modelMapper.map(book.get(),BookResponse.class);
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }

    @Override
    public List<BookResponse> getAllEmployees() {
        var books = bookRepository.findAll().stream()
                            .map( book -> modelMapper.map(book,BookResponse.class))
                            .toList();
        return books;
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest req) throws BookNotFoundException {

        if(bookRepository.existsById(id)){
            var book = bookRepository.findById(id);
            book.get().setTitle(req.getTitle()!=null ? req.getTitle() : book.get().getTitle());
            book.get().setPrice(req.getPrice()!=0 ? req.getPrice() : book.get().getPrice());

            var savedBook = bookRepository.save(book.orElse(null));

            return modelMapper.map(savedBook, BookResponse.class);
        }
        throw new BookNotFoundException("book not found with id: " +id);
    }
}
