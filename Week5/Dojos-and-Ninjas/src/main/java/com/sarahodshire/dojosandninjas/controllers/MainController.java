//Ended up not using this.

//package com.sarahodshire.dojosandninjas.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.sarahodshire.dojosandninjas.models.Dojo;
//import com.sarahodshire.dojosandninjas.models.Ninja;
//import com.sarahodshire.dojosandninjas.services.DojoService;
//import com.sarahodshire.dojosandninjas.services.NinjaService;
//
//
//@Controller
//public class MainController {
//	
//	//Services
//	@Autowired
//	private NinjaService ninjas;
//	@Autowired
//	private DojoService dojos;
//	
//	// Dojo's GET(rendering), POST(processing) & redirect
//	@GetMapping("/new/dojos")
//	public String newDojo(@ModelAttribute("dojo") Dojo d) {
//		return "dojoForm.jsp";
//	}
//	
//	@PostMapping("/dojos")
//	public String createDojo(@ModelAttribute("dojo") Dojo d) {
//		dojos.createDojo(d);
//		return("redirect:/dojos/%s");
//	}
//	
//	@GetMapping("/dojos/{id}")
//	public String showDojo(@PathVariable("id") Long id, Model model) {
//		Dojo d = dojos.findDojo(id);
//		model.addAttribute("dojo", d);
//		return "showDojo.jsp";
//	}
//	
//	// Ninja's GET(rendering), POST(processing) & redirect
//	@GetMapping("/new/ninjas")
//	public String newNinja(@ModelAttribute("ninja") Ninja n) {
//		return "ninjaForm.jsp";
//	}
//	
//	@PostMapping("/ninjas")
//	public String createNinja(@ModelAttribute("ninja") Ninja n) {
//		ninjas.createNinja(n);
//		return("redirect:/ninjas/%s");
//	}
//	
//	@GetMapping("/ninjas/{id}")
//	public String showNinja(@PathVariable("id") Long id, Model model) {
//		Ninja n = ninjas.findNinja(id);
//		model.addAttribute("ninja", n);
//		return "showNinja.jsp";
//	}
//}