package com.tts.d22_GroovyStore_1.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class LineItem {

	@NotBlank(message="Product can't be blank")
	private Product item;
	@Positive(message="Must have at least one item")
	private Short quantity;
	private Double lineTotal;
	
	public LineItem() {}
	
	public LineItem(@NotBlank(message = "Product can't be blank") Product item,
			@Positive(message = "Must have at least one item") Short quantity, Double lineTotal) {
		this.item = item;
		this.quantity = quantity;
		this.lineTotal = lineTotal;
	}

	public LineItem(@NotBlank(message = "Product can't be blank") Product item,
			@Positive(message = "Must have at least one item") Short quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public Product getItem() {
		return item;
	}
	public void setItem(Product item) {
		this.item = item;
	}
	public Short getQuantity() {
		return quantity;
	}
	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}
	public Double getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}
	@Override
	public String toString() {
		return "LineItem [item=" + item + ", quantity=" + quantity + ", lineTotal=" + lineTotal + "]";
	}
	
}
