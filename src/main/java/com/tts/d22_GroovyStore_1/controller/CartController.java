package com.tts.d22_GroovyStore_1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.d22_GroovyStore_1.model.Cart;
import com.tts.d22_GroovyStore_1.model.LineItem;
import com.tts.d22_GroovyStore_1.model.Product;
import com.tts.d22_GroovyStore_1.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/product/{productId}")
	public String addLineItemToCart(@PathVariable(value="product_id") Long id,
			@RequestParam(value="quantity", required=true) Short quantity,
			@RequestParam(value="cart") Cart cart, Model model,
			HttpServletRequest request) {
		Product product = productService.findById(id);
		LineItem lineItem = new LineItem();
		lineItem.setItem(product);
		lineItem.setQuantity(quantity);
		lineItem.setLineTotal(calcLineItemTotal(product, quantity));
		List<LineItem> itemsInCart = cart.getCartItems();
		itemsInCart.add(lineItem);
		cart.setCartItems(itemsInCart);
		calcNewCartTotal(cart);
		model.addAttribute("cart", cart);
		model.addAttribute("message", "Your cart was updated with a new item");
		return "redirect:" + request.getHeader("Referer");
	}
	
	private Double calcLineItemTotal(Product product, Short quantity) {
		Double total = product.getRetailPrice() * quantity;
		return total;
	}
	
	private void calcNewCartTotal(Cart cart) {
		List<LineItem> cartItems = cart.getCartItems();
		Double total = 0.0;
		for(LineItem item : cartItems) {
			total += item.getLineTotal();
		}
		cart.setCartTotal(total);
	}
	
	@PostMapping(value = "/removeItem/{name}")
	public String removeItemFromCart(@PathVariable(value="name") String name,
			@RequestParam(value="cart") Cart cart, Model model) {
		Product product = productService.findByName(name);
		LineItem lineItemToRemove = new LineItem();
		lineItemToRemove.setItem(product);
		List<LineItem> itemsInCart = cart.getCartItems();
		itemsInCart.remove(lineItemToRemove);
		model.addAttribute("cart", cart);
		model.addAttribute("message", "Item removed");
		return "cart";
	}
	
	@GetMapping(value = "/checkout")
	public String checkout(@RequestParam(value="cart") Cart cart, Model model) {
		model.addAttribute("cart", cart); //Reduce inventory by cart items, payment processing
		return "order";
	}
	
}
