package com.example.productorderservice.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

interface ProductRepository extends JpaRepository<Product, Long> {
    //class->interface로 변경하면서 아래 내용 삭제
//    private Map<Long, Product> persistence = new HashMap<>();
//    private Long sequence = 0L;
//
//
//    public void save(Product product) {
//        product.assignId(++sequence);
//        persistence.put(product.getId(), product);
//    }
}
