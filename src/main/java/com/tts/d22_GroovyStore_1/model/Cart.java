package com.tts.d22_GroovyStore_1.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Cart {

	@NotEmpty(message="Cart can't be empty")
	private List<LineItem> cartItems;
	private Double cartTotal;
	
	public Cart() {}

	public Cart(@NotEmpty(message = "Cart can't be empty") List<LineItem> cartItems, Double cartTotal) {
		this.cartItems = cartItems;
		this.cartTotal = cartTotal;
	}

	public Cart(@NotEmpty(message = "Cart can't be empty") List<LineItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<LineItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<LineItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(Double cartTotal) {
		this.cartTotal = cartTotal;
	}

	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + ", cartTotal=" + cartTotal + "]";
	}
	
}
