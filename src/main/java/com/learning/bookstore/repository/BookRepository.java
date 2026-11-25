package com.learning.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.bookstore.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long>{

}
