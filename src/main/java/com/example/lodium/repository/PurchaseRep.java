package com.example.lodium.repository;

import com.example.lodium.entity.Purchases;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRep extends JpaRepository<Purchases, Integer> {
}
