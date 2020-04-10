package com.tts.d22_GroovyStore_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tts.d22_GroovyStore_1.model.Product;
import com.tts.d22_GroovyStore_1.repository.ProductRepository;

@Controller
public class MainController {

	@Autowired
	public ProductRepository productRepository;

	@GetMapping("/")
	public String getStore(Model model) {
		List<Product> products = (List<Product>) productRepository.findAll();
		model.addAttribute("productList", products);
		return "main";
	}

}
