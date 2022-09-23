package com.sarahodshire.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarahodshire.dojosandninjas.models.Ninja;
import com.sarahodshire.dojosandninjas.services.DojoService;
import com.sarahodshire.dojosandninjas.services.NinjaService;


@Controller
public class NinjaController {

	//Service
	@Autowired
	private NinjaService ninjas;
	@Autowired
	private DojoService dojos;
	
	// GET(rendering), POST(processing) & redirect
	@GetMapping("/new/ninjas")
	public String newNinja(@ModelAttribute("ninja") Ninja n, Model model) {
		model.addAttribute("dojos", dojos.allDojos());
		return "ninjaForm.jsp";
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@ModelAttribute("ninja") Ninja n) {
		ninjas.createNinja(n);
		return"redirect:/dojos/%s" + n.getDojoId();
	}
	
//	@GetMapping("/ninjas/{id}")
//	public String showNinja(@PathVariable("id") Long id, Model model) {
//		Ninja n = ninjas.findNinja(id);
//		model.addAttribute("ninja", n);
//		return "showNinja.jsp";
//	}
}
