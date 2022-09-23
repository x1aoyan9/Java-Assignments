package com.sarahodshire.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarahodshire.dojosandninjas.models.Dojo;
import com.sarahodshire.dojosandninjas.services.DojoService;


@Controller
public class DojoController {

	//Service
	@Autowired
	private DojoService dojos;
	
	// GET(rendering), POST(processing) & redirect
	@GetMapping("/new/dojos")
	public String newDojo(@ModelAttribute("dojo") Dojo d) {
		return "dojoForm.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@ModelAttribute("dojo") Dojo d) {
		Dojo newDojo = dojos.createDojo(d);
		System.out.printf("Dojo id: %s", d.getId());
		return String.format("redirect:/dojos/%s", newDojo.getId());
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		System.out.printf("Dojo id: %s", id);
		Dojo d = dojos.findDojo(id);
		model.addAttribute("dojo", d);
		return "showDojo.jsp";
	}
}
