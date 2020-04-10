package com.tts.d22_GroovyStore_1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category {

	public enum Vehicle {
		TRUCK,
		MINIVAN,
		SEDAN,
		COOPE,
		CONVERTIBLE
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="Category must have a name")
	private Vehicle name = Vehicle.SEDAN;
	private String description;
	public Category() {}
	
	public Category(Vehicle name) {
		this.name = name;
	}
	
	public Category(Vehicle name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Vehicle getName() {
		return name;
	}
	public void setName(Vehicle name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
