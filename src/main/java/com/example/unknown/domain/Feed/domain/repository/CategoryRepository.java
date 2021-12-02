package com.example.unknown.domain.Feed.domain.repository;

import com.example.unknown.domain.Feed.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
