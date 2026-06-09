package com.melodyrent.service;
import com.melodyrent.dto.ProductDtos.ProductCard; import com.melodyrent.entity.*; import com.melodyrent.mapper.ProductMapper; import com.melodyrent.repository.*; import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import java.util.*;
@Service @RequiredArgsConstructor
public class RecommendationService {
  private final UserRepository users; private final ProductRepository products; private final UserActivityRepository activities; private final ProductMapper mapper;
  public List<ProductCard> personalized(String email){ var user=users.findByEmail(email).orElse(null); if(user==null) return trending(); var recent=activities.findTop25ByUserIdOrderByCreatedAtDesc(user.getId()); Optional<Long> category=recent.stream().filter(a -> a.getProduct()!=null).map(a -> a.getProduct().getCategory().getId()).findFirst(); var list=category.map(products::findTop12ByCategoryIdAndApprovedTrue).orElseGet(products::findTop12ByApprovedTrueOrderByCreatedAtDesc); if(list.isEmpty()) list=products.findTop12ByApprovedTrueOrderByCreatedAtDesc(); return list.stream().map(p -> mapper.toCard(p, 4.8)).toList(); }
  public List<ProductCard> trending(){ return products.findTop12ByApprovedTrueOrderByCreatedAtDesc().stream().map(p -> mapper.toCard(p,4.8)).toList(); }
  public void track(User user, Product product, ActivityType type, String metadata){ activities.save(UserActivity.builder().user(user).product(product).type(type).metadata(metadata).build()); }
}
