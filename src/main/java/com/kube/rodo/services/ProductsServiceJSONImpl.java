package com.kube.rodo.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kube.rodo.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Primary
@Service("JSON")
@ConditionalOnProperty(
        value="products.strategy",
        havingValue = "IN_JSON")
public class ProductsServiceJSONImpl implements ProductService {
    @Override
    public List<Product> getProduct() {
        List<Product> products;
        try{
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>(){});
            return products;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
