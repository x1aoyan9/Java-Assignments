package com.example.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.loginandregistration.models.LoginUser;
import com.example.loginandregistration.models.User;
import com.example.loginandregistration.services.PostService;
import com.example.loginandregistration.services.UserService;

@Controller
public class UserController {

	// service
	@Autowired
	private UserService users;
	
	@Autowired
	private PostService posts;

	@GetMapping("/")
	public String index(Model model) {
	// Bind empty User and LoginUser objects to the JSP
	// to capture the form input
		model.addAttribute("newU", new User());
		model.addAttribute("loginU", new LoginUser());
		return "index.jsp";
	}

	// view a user
	@GetMapping("/users/{id}")
	public String showUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", users.findUser(id));
		return "viewUser.jsp";
	}

	// edit user
	@GetMapping("/users/{id}/edit")
	public String editUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", users.findUser(id));
		return "editUser.jsp";
	}

	// submit new user
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

	// update user
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT) // @PutMapping - shorthand
	public String updateUser(@Valid @ModelAttribute("user") User u, BindingResult result) {
		if(result.hasErrors()) {
			return "editUser.jsp";
		} else {
			users.updateUser(u);
			return "redirect:/users/{id}";
		}
	}

	// deletion warning ??
	// experimenting/curious... don't know if it actually works
	@RequestMapping("/userWarning")
	public String flashMessages(RedirectAttributes flashWarning) {
		flashWarning.addFlashAttribute("warning", "Are you sure you wish to delete your account?");
		return "warning.jsp";
	}

	// delete user
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	public String destroyUser(@PathVariable("id") Long id) {
		users.deleteUser(id);
		return "redirect:/logout";
	}

	// login user
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

	// logged in and session
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {

		// if no userId found, redirect to logout
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		} else {
			// get userId from session [need to cast result to a Long as
			// "session.getAttribute('userId')" returns an object]
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", users.findUser(userId));
			model.addAttribute("posts", posts.allPosts());
		}
		return "dashboard.jsp";
	}

	// logout user
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		// set userId to null and redirect to index.jsp
		session.setAttribute("userId", null);
		return "redirect:/";
	}
	
}