package com.tailors.trynewmenu.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findTop8ByOrderByProductViewsDesc();
}
