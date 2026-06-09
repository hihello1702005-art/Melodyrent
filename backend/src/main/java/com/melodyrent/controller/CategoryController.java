package com.melodyrent.controller;
import com.melodyrent.entity.Category; import com.melodyrent.repository.CategoryRepository; import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/categories") @RequiredArgsConstructor
public class CategoryController { private final CategoryRepository categories; @GetMapping List<Category> all(){ return categories.findAll(); } }
