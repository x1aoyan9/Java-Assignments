package com.example.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dojoninjas.models.Dojo;
import com.example.dojoninjas.services.DojoService;

@Controller
public class DojoController {

	// service
	@Autowired
	private DojoService dojos;
	
	// create new dojo
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo d) {
		return "dojoForm.jsp";
	}
	
	// view a dojo
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo d = dojos.findDojo(id);
		model.addAttribute("dojo", d);
		return "showDojo.jsp";
	}
	
	// edit dojo
	@GetMapping("/dojos/{id}/edit")
	public String editDojo(@PathVariable("id") Long id, Model model) {
		Dojo d = dojos.findDojo(id);
		model.addAttribute("dojo", d);
		return "editDojo.jsp";
	}
	
	// submit new dojo
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo d, BindingResult result) {
		if(result.hasErrors()) {
			return "dojoForm.jsp";
		} else {
			dojos.createDojo(d);
			return "redirect:/dojos/{id}";
		}
	}
	
	// update dojo
	@PutMapping("/dojos/{id}")
	public String updateDojo(@Valid @ModelAttribute("dojo") Dojo d, BindingResult result) {
		if(result.hasErrors()) {
			return "editDojo.jsp";
		} else {
			dojos.updateDojo(d);
			return "redirect:/dojos/{id}";
		}
	}
	
	// delete a dojo
	@RequestMapping(value="/dojos/delete/{id}", method=RequestMethod.DELETE)
	public String destroyDojo(@PathVariable("id") Long id) {
		dojos.deleteDojo(id);
		return "redirect:/";
	}
}
