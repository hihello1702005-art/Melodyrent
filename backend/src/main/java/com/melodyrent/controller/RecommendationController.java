package com.melodyrent.controller;
import com.melodyrent.dto.ProductDtos.ProductCard; import com.melodyrent.service.RecommendationService; import lombok.RequiredArgsConstructor; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/recommendations") @RequiredArgsConstructor
public class RecommendationController { private final RecommendationService recommendations; @GetMapping List<ProductCard> all(Authentication auth){ return auth==null ? recommendations.trending() : recommendations.personalized(auth.getName()); } }
