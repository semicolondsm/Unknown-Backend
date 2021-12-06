package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.domain.Category;
import com.example.unknown.domain.Feed.domain.repository.CategoryRepository;
import com.example.unknown.domain.Feed.exception.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findCategoryByName(String categoryName) {

            return categoryRepository.findCategoryBycategoryName(categoryName)
                    .orElseThrow(() -> CategoryNotFoundException.EXCEPTION);

    }

}
