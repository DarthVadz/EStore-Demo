package com.tts.d22_GroovyStore_1.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Long id;
	@NotBlank(message="Must have brand")
	private String brand;
	@NotBlank(message="Must have model")
	private String model;
	@NotBlank(message="Must have name")
	private String name;
	@PositiveOrZero(message="Cost price cannot be negative")
	private Double costPrice;
	@PositiveOrZero(message="Retail price cannot be negative")
	private Double retailPrice;
	@PositiveOrZero(message="Inventory number cannot be negative")
	private Integer inventory;
	private String description;
	private String imgUrl;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="product_category", joinColumns = @JoinColumn(name="product_id"),
	inverseJoinColumns = @JoinColumn(name="category_id"))
	private Set<Category> categories;

	public Product() {}

	public Product(@NotBlank(message = "Must have brand") String brand,
			@NotBlank(message = "Must have model") String model, @NotBlank(message = "Must have name") String name) {
		this.brand = brand;
		this.model = model;
		this.name = name;
	}

	public Product(@NotBlank(message = "Must have brand") String brand,
			@NotBlank(message = "Must have model") String model, @NotBlank(message = "Must have name") String name,
			@PositiveOrZero(message = "Cost price cannot be negative") Double costPrice,
			@PositiveOrZero(message = "Retail price cannot be negative") Double retailPrice,
			@PositiveOrZero(message = "Inventory number cannot be negative") Integer inventory, String description,
			String imgUrl, Set<Category> categories) {
		this.brand = brand;
		this.model = model;
		this.name = name;
		this.costPrice = costPrice;
		this.retailPrice = retailPrice;
		this.inventory = inventory;
		this.description = description;
		this.imgUrl = imgUrl;
		this.categories = categories;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", model=" + model + ", name=" + name + ", costPrice="
				+ costPrice + ", retailPrice=" + retailPrice + ", inventory=" + inventory + ", description="
				+ description + ", imgUrl=" + imgUrl + ", categories=" + categories + "]";
	}
	
}
