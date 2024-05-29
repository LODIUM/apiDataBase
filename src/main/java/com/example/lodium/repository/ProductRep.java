package com.example.lodium.repository;

import com.example.lodium.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRep  extends JpaRepository<Product, Integer> {
}
