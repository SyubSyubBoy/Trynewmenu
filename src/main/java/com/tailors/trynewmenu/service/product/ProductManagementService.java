package com.tailors.trynewmenu.service.product;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.domain.product.ProductRepository;
import com.tailors.trynewmenu.service.product.exception.ProductNotFoundException;
import com.tailors.trynewmenu.service.product.exception.RemoveProductException;
import com.tailors.trynewmenu.ui.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductManagementService {

    @Autowired
    ProductRepository productRepository;

    public Product createNewProduct(final ProductDto.CreateRequest request) {
        if (productRepository.findById(request.getProductCode()).isPresent()) {
            throw new IllegalArgumentException("Product code is already exists!");
        }

        return productRepository.save(request.toEntity());
    }

    public Product updateProduct(final ProductDto.UpdateRequest request) {
        return productRepository.findById(request.getProductCode()).map(p -> {
            p.changeProductCode(request.getProductCode());
            p.changeProductName(request.getProductName());
            p.changePrice(request.getProductPrice());
            p.changeProductType(request.getProductType());
            return productRepository.save(p);
        }).orElseThrow(ProductNotFoundException::new);
    }

    public void deleteProduct(final String productCode) {
        try {
            productRepository.deleteById(productCode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoveProductException(e);
        }
    }
}
