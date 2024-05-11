package com.demo.infraestructure.inbound.controllers;

import com.demo.dominio.entities.Product;
import com.demo.infraestructure.adapter.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
        System.out.println("ProductController created");
    }


    @GetMapping("/products")
    public String getProducts() {
        Product product = new Product();
        //product.setId(new ObjectId("507f1f77bcf86cd799439011"));
        product.setName("Un producto");
        productRepository.save(product);
        return "products";
    }
}
