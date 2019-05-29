package com.tailors.trynewmenu.ui;

import com.tailors.trynewmenu.service.ProductService;
import com.tailors.trynewmenu.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProductDto.Response.MainResponse> findAllProducts() {
        return service.getMainProducts();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ProductDto.Response.MainResponse findByCode(@PathVariable("code") String productCode) {
        return service.getOne(productCode);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ProductDto.Response.MainResponse createOne(@RequestBody ProductDto.Request.CreateRequest request) {
        return service.createProduct(request);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ProductDto.Response.MainResponse updateOne(@RequestBody ProductDto.Request.UpdateRequest request) {
        return service.updateProduct(request);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ProductDto.Response.DeleteResponse deleteOne(@RequestBody ProductDto.Request.DeleteRequest request) {
        return service.deleteProduct(request.getProductCode());
    }
}
