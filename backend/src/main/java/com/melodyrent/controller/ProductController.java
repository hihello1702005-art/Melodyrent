package com.melodyrent.controller;
import com.melodyrent.dto.ProductDtos.*; import com.melodyrent.service.ProductService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.data.domain.*; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/products") @RequiredArgsConstructor
public class ProductController {
  private final ProductService products;
  @GetMapping Page<ProductCard> search(@RequestParam(required=false) String q, @RequestParam(required=false) Long categoryId, @RequestParam(required=false) String city, Pageable pageable){ return products.search(q, categoryId, city, pageable); }
  @GetMapping("/{id}") ProductCard get(@PathVariable Long id){ return products.get(id); }
  @PostMapping @PreAuthorize("hasAnyRole('OWNER','ADMIN')") ProductCard create(@Valid @RequestBody ProductRequest req, Authentication auth){ return products.create(req, auth.getName()); }
}
