package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.domain.Category;

import java.util.List;

public interface CategoryService {

    Category findCategoryByName(String categoryName);
}
