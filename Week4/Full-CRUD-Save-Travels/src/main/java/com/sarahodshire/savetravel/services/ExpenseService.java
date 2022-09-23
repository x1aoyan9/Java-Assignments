package com.sarahodshire.savetravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sarahodshire.savetravel.models.Expense;
import com.sarahodshire.savetravel.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;  // adding expense repository as a dependency
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> allExp() {  // return all entries
		return expenseRepo.findAll();
	}
	
	public Expense createExp(Expense e) {  // create new entry
		return expenseRepo.save(e);
	}
	
	public Expense findExp(Long id) {  // find entry (by id)
		//optional means the object can exist or not
		Optional<Expense> optionalExp = expenseRepo.findById(id);
		if(optionalExp.isPresent()) {
			return optionalExp.get();
		} else {
			return null;
		}
	}
	
	public Expense updateExp(Expense e) {  // update entry
		return expenseRepo.save(e);
	}
	
	public void deleteExp(Long id) {  // delete entry
		Optional<Expense> optionalExp = expenseRepo.findById(id);
		if(optionalExp.isPresent()) {
			expenseRepo.deleteById(id);
		}
	}
}
