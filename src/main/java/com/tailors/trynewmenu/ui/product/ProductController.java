package com.tailors.trynewmenu.ui.product;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.service.product.ProductFindService;
import com.tailors.trynewmenu.ui.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductFindService findService;

    @RequestMapping(value = "/hot", method = RequestMethod.GET)
    public List<ProductDto.Response> getHotProducts() {
        Pageable pageable = PageRequest.of(0, 8, Sort.by(Sort.Direction.DESC, "productViews"));
        Page<Product> result = findService.getProductsByPageable(pageable);
        return result.stream().map(ProductDto.Response::createResponse).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ProductDto.Response getProductByCode(@PathVariable("code") String code) {
        return ProductDto.Response.createResponse(findService.getProductByProductCode(code));
    }
}
