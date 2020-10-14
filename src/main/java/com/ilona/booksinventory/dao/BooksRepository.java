package com.ilona.booksinventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilona.booksinventory.entities.Book;

public interface BooksRepository extends JpaRepository<Book, String> {

}
