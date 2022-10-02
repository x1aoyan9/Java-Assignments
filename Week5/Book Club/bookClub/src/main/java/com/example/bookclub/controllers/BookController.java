package com.example.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookclub.models.Book;
import com.example.bookclub.services.BookService;
import com.example.bookclub.services.UserService;

@Controller
public class BookController {

	// service
	@Autowired
	private BookService books;

	// create new book
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute ("book") Book b, Model model, HttpSession session) {
		model.addAttribute("user",session.getAttribute("userId"));
		return "redirect:/books";
	}

	// submit new book
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book b, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("books", books.allBooks());
			return "createBook.jsp";
		} else {
			books.createBook(b);
			return "redirect:/dashboard";
		}
	}

	// edit book
	@GetMapping("/books/{id}/edit")
	public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		model.addAttribute("book", books.findBook(id));
		model.addAttribute("user",session.getAttribute("userId"));
		return "editBook.jsp";
	}

	// update book
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT) // @PutMapping - shorthand
	public String updateBook(@Valid @ModelAttribute("book") Book b, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("books", books.allBooks());
			return "editBook.jsp";
		} else {
			books.updateBook(b);
			return "redirect:/books/{id}";
		}
	}

	// delete book
	@RequestMapping(value = "/books/delete/{id}", method = RequestMethod.DELETE) // @DeleteMapping - shorthand
	public String destroyBook(@PathVariable("id") Long id) {
		books.destroyBook(id);
		return "redirect:/dashboard";
	}

	// view a book
	@GetMapping("/books/{id}")
	public String showBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		} else {
		model.addAttribute("book", books.findBook(id));
		model.addAttribute("user",session.getAttribute("userId"));
		return "viewBook.jsp";
		}
	}

	// view all books
	@GetMapping("/dashboard")
	public String books(Model model) {
		model.addAttribute("books", books.allBooks());
		return "dashboard.jsp";
	}
}