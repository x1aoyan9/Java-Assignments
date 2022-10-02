package com.example.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.example.dojoninjas.models.Dojo;
import com.example.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}

	// all dojos
// through error saying types didn't match with just - return dojoRepo.findAll()
// kept asking to change list to iterable or to add cast List<Dojo>
// a bit confused as to why only dojo's findAll did this and not also ninja's
	public List<Dojo> allDojos() {
		return (List<Dojo>) dojoRepo.findAll();
	}

	// create dojo
	public Dojo createDojo(@Valid Dojo d) {
		return dojoRepo.save(d);
	}

	// find dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> result = dojoRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	public void updateDojo(@Valid Dojo d) {
		return;
	}

	public void deleteDojo(Long id) {
		return;
	}
}