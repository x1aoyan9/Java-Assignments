package com.sarahodshire.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sarahodshire.dojosandninjas.models.Dojo;
import com.sarahodshire.dojosandninjas.models.Ninja;
import com.sarahodshire.dojosandninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
//	public Ninja findNinja(Long id) {
//		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
//		if(optionalNinja.isPresent()) {
//			return optionalNinja.get();
//		} else {
//			return null;
//		}
//	}
	
	public List<Ninja> byDojo(Dojo dojo) {
		return ninjaRepo.findAllByDojo(dojo);
	}
}
