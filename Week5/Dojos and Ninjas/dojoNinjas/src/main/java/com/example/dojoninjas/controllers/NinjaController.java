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

import com.example.dojoninjas.models.Ninja;
import com.example.dojoninjas.services.NinjaService;

@Controller
public class NinjaController {

	// service
	@Autowired
	private NinjaService ninjas;

	// create new ninja
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja n) {
		return "ninjaForm.jsp";
	}

	// show a ninja
	@GetMapping("/ninjas/{id}")
	public String showNinja(@PathVariable("id") Long id, Model model) {
		Ninja n = ninjas.findNinja(id);
		model.addAttribute("ninja", n);
		return "showNinja.jsp";
	}

	// edit ninja
	@GetMapping("/ninjas/{id}/edit")
	public String editNinja(@PathVariable("id") Long id, Model model) {
		Ninja n = ninjas.findNinja(id);
		model.addAttribute("ninja", n);
		return "editNinja.jsp";
	}

	// submit new ninja
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja n, BindingResult result) {
		if(result.hasErrors()) {
			return "ninjaForm.jsp";
		} else {
			ninjas.createNinja(n);
			return "redirect:/ninjas/{id}";
		}
	}

	// update ninja
	@PutMapping("/ninjas/{id}")
	public String updateNinja(@Valid @ModelAttribute("ninja") Ninja n, BindingResult result) {
		if(result.hasErrors()) {
			return "editNinja.jsp";
		} else {
			ninjas.updateNinja(n);
			return "redirect:/ninjas/{id}";
		}
	}

	// delete a ninja
	@RequestMapping(value="/ninjas/delete/{id}", method=RequestMethod.DELETE)
	public String destroyNinja(@PathVariable("id") Long id) {
		ninjas.deleteNinja(id);
		return "redirect:/";
	}
}