package com.tts.d22_GroovyStore_1.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.d22_GroovyStore_1.model.Product;
import com.tts.d22_GroovyStore_1.repository.ProductRepository;
import com.tts.d22_GroovyStore_1.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value="/product/{product_id}")
	public String getProduct(@PathVariable(value = "product_id") Long product_id, Model model) {
		Optional<Product> product = productRepository.findById(product_id);
		model.addAttribute("product", product);
		return "showProduct";
	}
	
	@GetMapping(value="/product/new")
	public String getNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "newProduct";
	}
	
	@PostMapping(value="/product/new")
	public String createNewProduct(@Valid Product product) {
		productService.saveNewProduct(product);
		return "main";
	}

	@GetMapping(value="/product/{productId}/edit")
	public String getEditProductForm(@PathVariable(value = "productId") Long id, Model model) {
		Product product = productRepository.findProductById(id);
		model.addAttribute("product", product);
		return "editProduct";
	}
	
	@PostMapping(value = "/product/{productId}/edit")
	public String updateProduct(@PathVariable(value = "productID") Long id, Product product, Model model) {
		Product updateProduct = productRepository.findProductById(id);
		updateProduct.setBrand(product.getBrand());
		updateProduct.setModel(product.getModel());
		updateProduct.setName(product.getName());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setCostPrice(product.getCostPrice());
		updateProduct.setRetailPrice(product.getRetailPrice());
		updateProduct.setInventory(product.getInventory());
		updateProduct.setCategories(product.getCategories());
//		updateProduct.setImgUrl(product.getImgUrl());
		productRepository.save(updateProduct);
		model.addAttribute("product", updateProduct);
		return "showProduct";
	}
	
}
