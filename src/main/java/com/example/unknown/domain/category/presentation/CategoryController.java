package com.example.unknown.domain.category.presentation;

import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.awt.print.Pageable;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public void getCategory(@RequestParam("category") @NotEmpty String category,
                            User user,
                            Pageable page) {


    }
}
