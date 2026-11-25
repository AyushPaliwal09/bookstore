package com.learning.bookstore.controller;

import com.learning.bookstore.model.BookModel;
import com.learning.bookstore.service.BookSevice;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor 
@RestController 
@RequestMapping("/api/v1/books")
public class BookController {
    
    private final BookSevice bookSevice;

    @GetMapping("")
    public List<BookModel> getAllBooks() {
        return bookSevice.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookModel getBookById(@PathVariable Long id) {
        return bookSevice.getBookById(id);
    }
    
    @PostMapping("")
    public BookModel saveBook(@RequestBody BookModel book) {
        return bookSevice.saveBook(book);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookSevice.deleteBook(id);
    }

    @PatchMapping("/update/{id}")
    public BookModel updateBook(@PathVariable Long id, @RequestBody BookModel book){
        return bookSevice.updateBook(id, book);
    }
}
