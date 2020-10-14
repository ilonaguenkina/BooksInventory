package com.ilona.booksinventory.services;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilona.booksinventory.dao.BooksRepository;
import com.ilona.booksinventory.dao.OrdersRepository;
import com.ilona.booksinventory.entities.Book;
import com.ilona.booksinventory.entities.Order;

@Service
public class BooksInventoryServiceImpl implements BooksInventoryService {
	
	private BooksRepository booksRepository;
	private OrdersRepository ordersRepository;
	
	@Autowired
	public BooksInventoryServiceImpl(BooksRepository booksRepository,
								 OrdersRepository ordersRepository) {
		this.booksRepository = booksRepository;
		this.ordersRepository = ordersRepository;
	}

	@Transactional
	public int addBook(Book book) {
		Optional<Book> existingBook = booksRepository.findById(book.getName());
		if (existingBook.isPresent()) {
			book.setQuantity(book.getQuantity() + existingBook.get().getQuantity());
		}
		booksRepository.save(book);
		return book.getQuantity();
	}
	
	public Collection<Book> getBooks() {
		return booksRepository.findAll();
	}
	
	@Transactional
	public int orderBook(Order order) {
		Optional<Book> existingBook = booksRepository.findById(order.getBookName());
		Book book = existingBook.isPresent() ? existingBook.get() : null;
		if (book == null || book.getQuantity() < order.getQuantity()) {
			order.setStatus(0);
		} else {
			order.setStatus(1);
			book.setQuantity(book.getQuantity() - order.getQuantity());
			if (book.getQuantity() == 0) {
				booksRepository.delete(book);
			} else {
				booksRepository.save(book);
			}
		}
		order = ordersRepository.save(order);
		return order.getOrderId();
	}
	
	public Order showOrder(int orderId) {
		Optional<Order> order = ordersRepository.findById(orderId);
		if (order.isPresent()) {
			return order.get();
		}
		
		return null;
	}
}
