package com.ilona.booksinventory.dao;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ilona.booksinventory.entities.Book;

public interface BooksRepository extends JpaRepository<Book, String> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select b from Book b where b.name = :name")
	Book findByIdForUpdate(@Param("name") String name);
}
