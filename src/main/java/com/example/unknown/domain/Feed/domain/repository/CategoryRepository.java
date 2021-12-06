package com.example.unknown.domain.Feed.domain.repository;

import com.example.unknown.domain.Feed.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryBycategoryName(String categoryName);
}
