package com.sarahodshire.savetravel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity //represents an entity model for application
@Table(name="trips") //sets this as a table in the database(DB)
public class Expense {

	@Id //sets this as the primary key(PK)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //@GenerateValue: sets this as auto-incrementing(AI) values
	private Long id; // Long used as a container for INT because it's primitive
	
	@NotBlank(message="Name required") //adds validation that the column must be null
	@Size(min = 1, max = 255) //@Size : adds validation that the column must be at least the specified range
	private String expenseName;

	@NotBlank(message="Vendor required")
	@Size(min = 1, max = 255)
	private String vendor;

	@NotNull(message="Price required")
	@Min(value=0, message="Please enter a valid amount.")
	private Double amount;

	@NotBlank(message="Description required")
	@Size(min = 1, max = 255)
	private String description;

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;


	public Expense() {}
	
	public Expense(@NotBlank String name, @NotBlank String vendor, @NotBlank String desc, @NotNull Double amount) {
		this.expenseName = name;
		this.vendor = vendor;
		this.description = desc;
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return expenseName;
	}
	
	public void setName(String name) {
		this.expenseName = name;
	}
	
	public String getVendor() {
		return vendor;
	}
	
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
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
	
	@PrePersist //runs method right before object is created
		protected void onCreate(){
			this.createdAt = new Date();
	}

	@PreUpdate //runs method when object is modified
		protected void onUpdate(){
			this.updatedAt = new Date();
	}
	
}
