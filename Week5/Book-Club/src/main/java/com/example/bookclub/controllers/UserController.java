package com.example.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookclub.models.LoginUser;
import com.example.bookclub.models.User;
import com.example.bookclub.services.UserService;

@Controller
public class UserController {

	// service
	@Autowired
	private UserService users;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newU", new User());
		model.addAttribute("loginU", new LoginUser());
		return "index.jsp";
	}

	// create new user
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newU") User newU, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("loginU", new LoginUser());
			return "index.jsp";
		} else {
			User u = users.createUser(newU, result);
			session.setAttribute("userId", u.getId());
			return "redirect:/dashboard";
		}
	}

	// login existing user
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginU") LoginUser loginU, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors() || users == null) {
			model.addAttribute("newU", new User());
			return "index.jsp";
		} else {
			User u = users.loginUser(loginU, result);
			session.setAttribute("userId", u.getId());
			return "redirect:/dashboard";
		}
	}

	// logged in user with session
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		} else {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", users.findUser(userId));
		}
		return "dashboard.jsp";
	}

	// logout user
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}
}