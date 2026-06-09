package com.melodyrent.repository;
import com.melodyrent.entity.PricingRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PricingRuleRepository extends JpaRepository<PricingRule, Long> { List<PricingRule> findByActiveTrue(); }
