package com.kube.rodo.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;

    public Product(Integer id, String name, Double price, Integer stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;

    }
    public Product(){

    }

}
