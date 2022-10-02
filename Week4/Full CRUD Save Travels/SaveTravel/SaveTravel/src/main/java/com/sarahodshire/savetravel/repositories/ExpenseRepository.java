package com.sarahodshire.savetravel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sarahodshire.savetravel.models.Expense;


@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
//	List<Expense> findByDesc(String search);
}