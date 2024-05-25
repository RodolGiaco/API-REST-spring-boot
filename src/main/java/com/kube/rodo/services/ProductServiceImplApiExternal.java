package com.kube.rodo.services;

import com.kube.rodo.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("API")
@ConditionalOnProperty(
        value="products.strategy",
        havingValue = "IN_OTHER_API")
public class ProductServiceImplApiExternal implements ProductService {
    @Override
    public List<Product> getProduct() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Product>> response = restTemplate.
                exchange("http://localhost:8080/storage/api/v1/products/fake-products",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
                });
        List<Product> products = response.getBody();
        return products;
    }
}
