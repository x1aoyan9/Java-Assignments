package com.example.loginandregistration.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginUser {

	@NotBlank(message = "Email required.")
	@Email(message = "Please enter a valid email.")
	private String email;

	@NotBlank(message = "Required")
	@Size(min = 8, max = 255, message = "Must be at least 8 characters.")
	private String password;
	
	public LoginUser() {}

	public LoginUser(
			@NotBlank(message = "Email required.") @Email(message = "Please enter a valid email.") String email,
			@NotBlank(message = "Required") @Size(min = 8, max = 255, message = "Must be at least 8 characters.") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
