package com.tailors.trynewmenu.service.product;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.domain.product.ProductRepository;
import com.tailors.trynewmenu.service.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductFindService {

    private final ProductRepository repository;

    public Page<Product> getProductsByPageable(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Product getProductByProductCode(final String productCode) {
        return repository.findById(productCode).orElseThrow(ProductNotFoundException::new);
    }
}
