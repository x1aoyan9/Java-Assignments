package com.example.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Required")
	@Size(min = 2, max = 255, message = "Must be at least 2 characters.")
	private String fName;
	
	@NotBlank(message = "Required")
	@Size(min = 2, max = 255, message = "Must be at least 2 characters.")
	private String lName;
	
	@NotBlank(message = "Email required.")
	@Email(message = "Please enter a valid email.")
	private String email;
	
	@NotBlank(message = "Required")
	@Size(min = 8, max = 255, message = "Must be at least 8 characters.")
	private String password;
	
	@Transient
	@NotBlank(message = "Required")
	@Size(min = 8, max = 255, message = "Must be at least 8 characters.")
	private String confirmPass;
	
	@Column(updatable =  false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Book> books;
	
	public User(){}

	public User(Long id,
			@NotBlank(message = "Required") @Size(min = 2, max = 255, message = "Must be at least 2 characters.") String fName,
			@NotBlank(message = "Required") @Size(min = 2, max = 255, message = "Must be at least 2 characters.") String lName,
			@NotBlank(message = "Email required.") @Email(message = "Please enter a valid email.") String email,
			@NotBlank(message = "Required") @Size(min = 8, max = 255, message = "Must be at least 8 characters.") String password,
			@NotBlank(message = "Required") @Size(min = 8, max = 255, message = "Must be at least 8 characters.") String confirmPass,
			Date createdAt, Date updatedAt, List<Book> books) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.confirmPass = confirmPass;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setUsers(List<Book> books) {
		this.books = books;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}