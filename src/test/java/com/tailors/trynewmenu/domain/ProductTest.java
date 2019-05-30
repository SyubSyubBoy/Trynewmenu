package com.tailors.trynewmenu.domain;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.domain.product.ProductRepository;
import com.tailors.trynewmenu.domain.product.exception.ProductNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    ProductRepository repository;

    @Test
    public void test() {
        Product product = Product.builder()
                .productType("ANG")
                .productCode("UBD")
                .productName("ff")
                .productPrice(2000)
                .build();

        product.save();

        repository.findById(product.getProductCode()).map(pr -> {
            assertThat(pr.getProductCode(), is(product.getProductCode()));
            return pr;
        }).orElseThrow(ProductNotFoundException::new);
    }
}
