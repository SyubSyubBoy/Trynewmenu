package com.tailors.trynewmenu.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findTop8ByOrderByProductViewsDesc();
    Page<Product> findAll(Pageable pageable);
}
