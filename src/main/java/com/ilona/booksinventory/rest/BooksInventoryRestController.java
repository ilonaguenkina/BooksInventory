package com.ilona.booksinventory.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilona.booksinventory.entities.Book;
import com.ilona.booksinventory.entities.Order;

@RestController
@RequestMapping("/book")
public class BooksInventoryRestController {

	@PostMapping
	public int addBook(@RequestBody Book book) {
		return 1;
	}
	
	@GetMapping
	public Collection<Book> getBooks() {
		return null;
	}
	
	@PostMapping("/order")
	public boolean orderBook(@RequestBody Order order) {
		return true;
	}
	
	@GetMapping("/order/{id}")
	public Order showOrder() {
		return null;
	}
}
