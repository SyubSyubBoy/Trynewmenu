package com.tailors.trynewmenu.domain;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.domain.product.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    ProductRepository repository;

    @Before
    public void testBefore() {
        Product product = Product.builder()
                .productCode("UBD")
                .productName("dkd")
                .productPrice(1000)
                .productType("hihi")
                .build();
    }

    @Test
    public void test() {

    }
}
