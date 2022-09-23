package com.example.loginandregistration.controllers;

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

import com.example.loginandregistration.models.Post;
import com.example.loginandregistration.services.PostService;

@Controller
public class PostController {

	// service
	@Autowired
	private PostService posts;

	// create new post
	@GetMapping("/posts/new")
	public String newPost(@ModelAttribute("post") Post p) {
		return "redirect:/posts";
	}

	// view a post
	@GetMapping("/posts/{id}")
	public String showPost(@PathVariable("id") Long id, Model model) {
		model.addAttribute("post", posts.findPost(id));
		return "viewPost.jsp";
	}

	// edit post
	@GetMapping("/posts/{id}/edit")
	public String editPost(@PathVariable("id") Long id, Model model) {
		model.addAttribute("posts", posts.allPosts());
		model.addAttribute("post", posts.findPost(id));
		return "editPost.jsp";
	}

	// submit new post
	@PostMapping("/posts")
	public String createPost(@Valid @ModelAttribute("post") Post p, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("posts", posts.allPosts());
			return "createPost.jsp";
		} else {
			posts.createPost(p);
			return "redirect:/dashboard";
		}
	}

	// update post
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT) // @PutMapping - shorthand
	public String updatePost(@Valid @ModelAttribute("post") Post p, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("posts", posts.allPosts());
			return "editPost.jsp";
		} else {
			posts.updatePost(p);
			return "redirect:/posts/{id}";
		}
	}

	// delete post
	@RequestMapping(value = "/posts/delete/{id}", method = RequestMethod.DELETE) // @DeleteMapping - shorthand
	public String destroyPost(@PathVariable("id") Long id) {
		posts.destroyPost(id);
		return "redirect:/dashboard";
	}
}