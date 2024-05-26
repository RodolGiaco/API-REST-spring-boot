package com.kube.rodo.domain;

import lombok.*;

//@Setter
//@Getter
//@EqualsAndHashCode
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;

}
