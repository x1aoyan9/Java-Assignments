package com.example.bookclub.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Required")
	@Size(min = 1, max = 255, message = "Must be at least 1 characters.")
	private String bTitle;
	
	@NotBlank(message = "Required")
	@Size(min = 1, max = 255, message = "Must be at least 1 characters.")
	private String bAuthor;
	
	@NotBlank(message = "Required.")
	@Size(min = 2, max = 255, message = "Must be at least 2 characters.")
	private String bNote;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User poster;
	
	public Book(){}

	public Book(Long id,
			@NotBlank(message = "Required") @Size(min = 1, max = 255, message = "Must be at least 1 characters.") String bTitle,
			@NotBlank(message = "Required") @Size(min = 1, max = 255, message = "Must be at least 1 characters.") String bAuthor,
			@NotBlank(message = "Required.") @Size(min = 2, max = 255, message = "Must be at least 2 characters.") String bNote,
			Date createdAt, Date updatedAt, User poster) {
		super();
		this.id = id;
		this.bTitle = bTitle;
		this.bAuthor = bAuthor;
		this.bNote = bNote;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.poster = poster;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getbNote() {
		return bNote;
	}

	public void setbNote(String bNote) {
		this.bNote = bNote;
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

	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
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