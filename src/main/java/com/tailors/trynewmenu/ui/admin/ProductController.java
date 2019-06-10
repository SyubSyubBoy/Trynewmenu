package com.tailors.trynewmenu.ui.admin;

import com.tailors.trynewmenu.service.ProductService;
import com.tailors.trynewmenu.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto.Response.MainResponse> findAllProducts() {
        return service.getMainProducts();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ProductDto.Response.MainResponse findByCode(@PathVariable("code") String productCode) {
        return service.getOne(productCode);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductDto.Response.MainResponse createOne(@RequestBody ProductDto.Request.CreateRequest request) {
        return service.createProduct(request);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ProductDto.Response.MainResponse updateOne(@RequestBody ProductDto.Request.UpdateRequest request) {
        return service.updateProduct(request);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ProductDto.Response.ResultResponse deleteOne(@RequestBody ProductDto.Request.DeleteRequest request) {
        return service.deleteProduct(request.getProductCode());
    }
}
