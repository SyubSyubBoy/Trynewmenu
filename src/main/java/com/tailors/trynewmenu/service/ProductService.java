package com.tailors.trynewmenu.service;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.domain.product.exception.ProductNotFoundException;
import com.tailors.trynewmenu.domain.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    public List<Product> getMainProducts() {
        return productRepository.findTop8ByOrderByProductViewsDesc();
    }

    public Product getOne(String productCode) {
        return productRepository.findById(productCode).orElseThrow(ProductNotFoundException::new);
    }

    public Product createProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public Product updateProduct(Product target) {
        return productRepository.findById(target.getProductCode()).map(product -> product.update(target))
                .orElseThrow(ProductNotFoundException::new);
    }

    public boolean deleteProduct(String code) {
        try {
            productRepository.deleteById(code);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Delete fail!");
            return false;
        }
    }
}
