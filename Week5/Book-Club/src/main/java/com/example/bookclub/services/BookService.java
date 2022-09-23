package com.example.bookclub.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookclub.models.Book;
import com.example.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private final BookRepository bookRepo;

	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	// find book(s) by user
	public List<Book> findByUser(Long userId) {
		return bookRepo.findByUser(userId);
	}

	// create a new book
	public Book createBook(@Valid Book b) {
		return bookRepo.save(b);
	}

	// all books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// find a book
	public Book findBook(Long id) {
		Optional<Book> result = bookRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	// update book
	public Book updateBook(@Valid Book b) {
		return bookRepo.save(b);
	}

	// delete book
	public void destroyBook(Long id) {
		Optional<Book> result = bookRepo.findById(id);
		if(result.isPresent()) {
			bookRepo.deleteById(id);
		}
	}
}