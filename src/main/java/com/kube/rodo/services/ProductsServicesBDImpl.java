package com.kube.rodo.services;

import com.kube.rodo.domain.Product;
import com.kube.rodo.persistance.entities.ProductEntity;
import com.kube.rodo.persistance.repositories.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("BD")
@ConditionalOnProperty(
        value="products.strategy",
        havingValue = "IN_BD")
public class ProductsServicesBDImpl implements ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Product> getProduct() {
        List<ProductEntity> productEntities = productsRepository.findAll();
        List<Product> products = new ArrayList<>();

        for (ProductEntity productEntity : productEntities) {
            Product product = new Product();
            product.setId(productEntity.getId());
            product.setName(productEntity.getName());
            product.setPrice(productEntity.getPrice());
            product.setStock(productEntity.getStock());
            products.add(product);
        }
        return products;
    }
}