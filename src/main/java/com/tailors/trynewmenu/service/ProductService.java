package com.tailors.trynewmenu.service;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.domain.product.exception.ProductNotFoundException;
import com.tailors.trynewmenu.domain.product.ProductRepository;
import com.tailors.trynewmenu.service.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    public List<ProductDto.Response.MainResponse> getMainProducts() {
        return productRepository.findTop8ByOrderByProductViewsDesc()
                .stream().map(ProductDto.Response.MainResponse::new).collect(Collectors.toList());
    }

    public ProductDto.Response.MainResponse getOne(String productCode) {
        return productRepository.findById(productCode).map(ProductDto.Response.MainResponse::new)
                .orElseThrow(ProductNotFoundException::new);
    }

    public ProductDto.Response.MainResponse createProduct(ProductDto.Request.CreateRequest newProduct) {
        Product result = newProduct.toEntity();
        return new ProductDto.Response.MainResponse(productRepository.save(result));
    }

    public ProductDto.Response.MainResponse updateProduct(ProductDto.Request.UpdateRequest target) {
        return productRepository.findById(target.getProductCode()).map(product ->
                new ProductDto.Response.MainResponse(product.update(target.toEntity())))
                .orElseThrow(ProductNotFoundException::new);
    }

    public ProductDto.Response.ResultResponse deleteProduct(String code) {
        ProductDto.Response.ResultResponse response = new ProductDto.Response.ResultResponse(false);

        try {
            productRepository.deleteById(code);
            response.setResult(true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Delete failed");
        }

        return response;
    }
}
