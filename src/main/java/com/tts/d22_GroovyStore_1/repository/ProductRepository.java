package com.tts.d22_GroovyStore_1.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.d22_GroovyStore_1.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findProductsByCategory(String category);
	List<Product> findProductsByBrand(String brand);
	Product findByModel(String model);
	Product findByName(String name);
	Product findProductById(Long id);
}
