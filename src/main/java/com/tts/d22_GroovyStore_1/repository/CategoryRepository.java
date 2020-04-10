package com.tts.d22_GroovyStore_1.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.d22_GroovyStore_1.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Set<Category> findCategoriesByNames(Set<Category> names);
}
