package com.tailors.trynewmenu.domain;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.domain.product.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProductTest {

    @Autowired
    ProductRepository repository;

    @Test
    public void prduct_CRUD() {
        Product product = Product.builder()
                .productCode("UBD")
                .productType("의류")
                .productName("앙")
                .productPrice(12400)
                .build();
        product.save();

        assertThat(repository.findById(product.getProductCode()).isPresent(), is(true));
        product.changePrice(12600).save();
        assertThat(repository.findById(product.getProductCode()).get().getProductPrice(), is(12600));

        repository.deleteById(product.getProductCode());
        assertThat(repository.count(), is(0l));
    }
}
