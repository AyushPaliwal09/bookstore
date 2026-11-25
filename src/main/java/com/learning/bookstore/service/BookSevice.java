package com.learning.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.bookstore.model.BookModel;
import com.learning.bookstore.repository.BookRepository;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class BookSevice {

    private final BookRepository bookRepo;

    public List<BookModel> getAllBooks() {
        return bookRepo.findAll();
    }

    public BookModel getBookById(Long id) {
        if(bookRepo.findById(id).isPresent()) {
            return bookRepo.findById(id).get();
        }
        else {
            throw new RuntimeException("Book Not found!");
        }
    }
    
    public BookModel saveBook(BookModel book) {
        BookModel savedBook = bookRepo.save(book);
        return savedBook;
    }

    public void deleteBook(Long id) {
        if( bookRepo.findById(id).isPresent()) {
            bookRepo.deleteById(id);
        }
        else {
            throw
            new RuntimeException("Book Not Found!");
        }
    }

    public BookModel updateBook(Long id, BookModel book) {
        if(bookRepo.findById(id).isPresent()) {
            BookModel existingBook = bookRepo.findById(id).get();

            existingBook.setTitle(book.getTitle());
            existingBook.setDescription(book.getDescription());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());

            BookModel updatedBook = bookRepo.save(existingBook);
            return updatedBook;
        }
        else {
            throw 
            new RuntimeException("Book Not found!");    
        }
    }
}
