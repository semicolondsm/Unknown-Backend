package com.example.unknown.domain.category.domain.repository;

import com.example.unknown.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
