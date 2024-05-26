package com.kube.rodo.services;

import com.kube.rodo.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Lazy
@Primary
@Service("MEMORY")
@ConditionalOnProperty(
        value="products.strategy",
        havingValue = "IN_MEMORY")
public class ProductsServicesImpl implements ProductService {
    private List<Product> product = new ArrayList(Arrays.asList(
            new Product(1, "Barra", 22000.0,100),
            new Product(2, "Paralelas", 32000.0, 20),
            new Product(3, "Anillas", 50000.0,10)
    ));

    public List<Product> getProduct() {
        return product;
    }
    public ProductsServicesImpl(){
        log.info("ProductsServicesImpl initialized");
    }
}
