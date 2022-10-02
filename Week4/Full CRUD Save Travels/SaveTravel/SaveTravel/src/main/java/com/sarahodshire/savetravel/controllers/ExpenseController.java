package com.sarahodshire.savetravel.controllers;

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

import com.sarahodshire.savetravel.models.Expense;
import com.sarahodshire.savetravel.services.ExpenseService;


@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String dashboard(@ModelAttribute("expense") Expense e, Model model) {
//		List<Expense> expenses = expenseService.allExp();
//		model.addAttribute("expenses", expenses);
		model.addAttribute("expenses", expenseService.allExp());
		return "index.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String view(@PathVariable("id")Long id, Model model) {
		model.addAttribute("expense", expenseService.findExp(id));
		return "view.jsp";
	}
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense e, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExp());
			return "index.jsp";
		} else {
			expenseService.createExp(e);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		model.addAttribute("expense", expenseService.findExp(id));
		model.addAttribute("expenses", expenseService.allExp());
		return "edit.jsp";
	}

	@RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT) //@PutMapping - shorthand
	public String update(@PathVariable("id")Long id, @Valid @ModelAttribute("expense") Expense e, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.findExp(id));
			return "edit.jsp";
		} else {
			expenseService.updateExp(e);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping(value="/expenses/delete/{id}", method=RequestMethod.DELETE) //@DeleteMapping - shorthand
	public String destroy(@PathVariable("id")Long id) {
		expenseService.deleteExp(id);
		return "redirect:/expenses";
	}
}