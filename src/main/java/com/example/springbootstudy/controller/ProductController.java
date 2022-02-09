package com.example.springbootstudy.controller;

import com.example.springbootstudy.data.dto.ProductDTO;
import com.example.springbootstudy.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDTO getProduct(@PathVariable String productId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[Product Controller] perform {} of Spring Study API", "getProduct()");

        ProductDTO productDTO = productService.getProduct(productId);

        LOGGER.info("[Product Controller] Response :: productId = {}, productName = {}, productPrice = {}, productStock ={}, Response Time = {}ms", productDTO.getProductId(), productDTO.getProductName(), productDTO.getProductPrice(), productDTO.getProductPrice(), productDTO.getProductStock(), (System.currentTimeMillis() - startTime));

        return productDTO;
    }

    @PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

}
