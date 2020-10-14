package com.ilona.booksinventory.services;

import java.util.Collection;

import com.ilona.booksinventory.entities.Book;
import com.ilona.booksinventory.entities.Order;

public interface BooksInventoryService {
	public int addBook(Book book);
	
	public Collection<Book> getBooks();
	
	public int orderBook(Order order);
	
	public Order showOrder(int orderId);
}
