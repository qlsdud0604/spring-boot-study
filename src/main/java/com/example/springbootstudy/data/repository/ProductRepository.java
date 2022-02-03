package com.example.springbootstudy.data.repository;

import com.example.springbootstudy.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
