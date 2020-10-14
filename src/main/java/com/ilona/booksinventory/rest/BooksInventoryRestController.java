package com.ilona.booksinventory.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilona.booksinventory.entities.Book;
import com.ilona.booksinventory.entities.Order;
import com.ilona.booksinventory.services.BooksInventoryService;

@RestController
@RequestMapping("/book")
public class BooksInventoryRestController {
	
	@Autowired
	private BooksInventoryService service;

	@PostMapping
	public int addBook(@RequestBody Book book) {
		return service.addBook(book);
	}
	
	@GetMapping
	public Collection<Book> getBooks() {
		return service.getBooks();
	}
	
	@PostMapping("/order")
	public int orderBook(@RequestBody Order order) {
		return service.orderBook(order);
	}
	
	@GetMapping("/order/{id}")
	public Order showOrder(@PathVariable int id) {
		return service.showOrder(id);
	}
}
