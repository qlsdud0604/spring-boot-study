package com.example.springbootstudy.data.handler;

import com.example.springbootstudy.data.entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String prodyctId);
}
