package com.example.springbootstudy.data.dao;

import com.example.springbootstudy.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
