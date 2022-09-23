package com.example.bookclub.services;

import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.bookclub.models.LoginUser;
import com.example.bookclub.models.User;
import com.example.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	// creating new user
	public User createUser(User newU, BindingResult result) {

		// checking if email is already in db
		Optional<User> existingU = userRepo.findByEmail(newU.getEmail());
		if(existingU.isPresent()) {
			result.rejectValue("email", "Matches", "Email already taken.");
		}

		// checking if password and confirm password match
		if(!newU.getPassword().equals(newU.getConfirmPass())) {
			result.rejectValue("confirmPass", "Matches", "Passwords do not match!");
		}

		// returns null if result has errors
		if(result.hasErrors()) {
			return null;
		}

		// hash and set password + save user to db
		String hashed = BCrypt.hashpw(newU.getPassword(), BCrypt.gensalt());
		newU.setPassword(hashed);
		userRepo.save(newU);
		return newU;
	}

	// login user
	public User loginUser(@Valid LoginUser loginU, BindingResult result) {

		// searching db for email and rejects if NOT present
		Optional<User> existingU = userRepo.findByEmail(loginU.getEmail());
		if(!existingU.isPresent()) {
			result.rejectValue("email", "Matches", "User not found!");
			return null;
		}
		
		// existing user and retrieving user info from db
		User user = existingU.get();
		
		// rejects if BCrypt password match fails
		if(!BCrypt.checkpw(loginU.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Email/Password!");
		}
		
		// returns null if result has errors
		if(result.hasErrors()) {
			return null;
		}
		
		// if successful, returns user (object)
		return user;
	}

	// find user
	public User findUser(Long id) {
		Optional<User> existingU = userRepo.findById(id);
		if(existingU.isPresent()) {
			return existingU.get();
		} else {
			return null;
		}
	}
}