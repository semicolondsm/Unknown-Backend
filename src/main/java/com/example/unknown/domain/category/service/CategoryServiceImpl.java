package com.example.unknown.domain.category.service;

import com.example.unknown.domain.Feed.exception.CategoryNotFoundException;
import com.example.unknown.domain.category.domain.Category;
import com.example.unknown.domain.category.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByCategoryName(categoryName)
                .orElseThrow(() -> CategoryNotFoundException.EXCEPTION);
    }
}

