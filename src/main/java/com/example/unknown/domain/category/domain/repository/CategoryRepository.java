package com.example.unknown.domain.category.domain.repository;

import com.example.unknown.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findCategoryByCategoryName(String categoryName);

}
