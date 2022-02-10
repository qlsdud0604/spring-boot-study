package com.example.springbootstudy.controller;

import com.example.springbootstudy.data.dto.ProductDTO;
import com.example.springbootstudy.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        LOGGER.info("[getProduct] perform {} of Spring Study API", "getProduct()");

        ProductDTO productDTO = productService.getProduct(productId);

        LOGGER.info("[Product Controller] Response :: productId = {}, productName = {}, productPrice = {}, " +
                        "productStock ={}, Response Time = {}ms", productDTO.getProductId(), productDTO.getProductName(),
                productDTO.getProductPrice(), productDTO.getProductStock(),
                (System.currentTimeMillis() - startTime));

        return productDTO;
    }

    @PostMapping(value = "/product")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {

//        /** Validation Code Example */
//        if (productDTO.getProductId().equals("") || productDTO.getProductId().isEmpty()) {
//            LOGGER.error("[createProduct] Failed Response :: productId id Empty");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDTO);
//        }

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        ProductDTO response = productService.saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info("[createProduct] Response :: productId = {}, productName = {}, productPrice = {}, " +
                        "productStock ={}, Response Time = {}ms", response.getProductId(), response.getProductName(),
                response.getProductPrice(), response.getProductStock());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
