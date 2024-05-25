package com.kube.rodo.controller;

import com.kube.rodo.configurations.ConfigurationParameters;
import com.kube.rodo.domain.Product;
import com.kube.rodo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    @Lazy
    @Autowired
    private ProductService productsService;

    @Autowired
    private ConfigurationParameters configurationParameters;
    @GetMapping
    public ResponseEntity<?> getProducts() {
        System.out.println("params:" + configurationParameters.toString());
        List<Product> product = productsService.getProduct();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/fake-products")
    public ResponseEntity<?> fakeProductAPI() {
         List<Product> product = new ArrayList(Arrays.asList(
                new Product(1, "A10", 10000.0,20),
                new Product(2, "A11", 30000.0, 31),
                new Product(3, "A12", 50000.0,17)
        ));
        return ResponseEntity.ok(product);
    }
}
