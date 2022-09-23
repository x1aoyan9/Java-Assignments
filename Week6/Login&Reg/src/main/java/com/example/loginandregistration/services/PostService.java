package com.example.loginandregistration.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginandregistration.models.Post;
import com.example.loginandregistration.models.User;
import com.example.loginandregistration.repositories.PostRepository;
import com.example.loginandregistration.repositories.UserRepository;

@Service
public class PostService {

	@Autowired
	private final PostRepository postRepo;

	public PostService(PostRepository postRepo) {
		this.postRepo = postRepo;
	}

	// all posts
	public List<Post> allPosts() {
		return postRepo.findAll();
	}

	// create post
	public Post createPost(@Valid Post p) {
		return postRepo.save(p);
	}

	// find post
	public Post findPost(Long id) {
		Optional<Post> result = postRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	// update post
	public Post updatePost(Post p) {
		return postRepo.save(p);
	}

	// delete post
	public void destroyPost(Long id) {
		Optional<Post> result = postRepo.findById(id);
		if(result.isPresent()) {
			postRepo.deleteById(id);
		}
	}
}