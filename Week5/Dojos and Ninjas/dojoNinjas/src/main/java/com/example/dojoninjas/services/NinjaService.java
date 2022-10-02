package com.example.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.example.dojoninjas.models.Dojo;
import com.example.dojoninjas.models.Ninja;
import com.example.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	// all ninjas
// added cast List<Ninja> to stay consistent to dojo's
// not sure if it adds anything, or if it's just extra typing?
	public List<Ninja> allNinjas() {
		return (List<Ninja>) ninjaRepo.findAll();
	}

	// create ninja
	public Ninja createNinja(@Valid Ninja n) {
		return ninjaRepo.save(n);
	}

	// find ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> result = ninjaRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}
	
	public List<Ninja> byDojo(Dojo d) {
		return ninjaRepo.findByDojo(d);
	}

	public void updateNinja(@Valid Ninja n) {
		return;
	}

	public void deleteNinja(Long id) {
		return;
	}
}
