package com.kube.rodo.services;

import com.kube.rodo.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductService {

    public List<Product> getProduct();
}
