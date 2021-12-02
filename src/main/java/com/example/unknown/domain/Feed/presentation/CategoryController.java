package com.example.unknown.domain.Feed.presentation;

import com.example.unknown.domain.Feed.domain.Category;
import com.example.unknown.domain.Feed.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }
}
