package com.tts.d22_GroovyStore_1.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.d22_GroovyStore_1.model.Category;
import com.tts.d22_GroovyStore_1.model.Product;
import com.tts.d22_GroovyStore_1.repository.CategoryRepository;
import com.tts.d22_GroovyStore_1.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	@Autowired
	ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public List<Product> findProductsByCategory(String category) {
		List<Product> products = productRepository.findProductsByCategory(category);
		return products;
	}
	
	public List<Product> findProductsByBrand(String brand) {
		List<Product> products = productRepository.findProductsByBrand(brand);
		return products;
	}
	
	public Product findByModel(String model) {
		Product product = productRepository.findByModel(model);
		return product;
	}
	
	public Product findByName(String name) {
		Product product = productRepository.findByName(name);
		return product;
	}
	
	public Product findById(Long id) {
		Product product = productRepository.findProductById(id);
		return product;
	}

	public void save(Product product) {
		productRepository.save(product);
	}
	
	public Product saveNewProduct(Product product) {
//		Set<Category> productCategories = categoryRepository.findCategoriesByNames(product.getCategories());
		if(product.getCostPrice()==null) product.setCostPrice(0.0);
		if(product.getRetailPrice()==null) product.setRetailPrice(0.0);
		if(product.getInventory()==null) product.setInventory(0);
		return productRepository.save(product);
	}
	
}
